function updateClock() {
    const now = new Date();
    const formattedTime = now.getHours().toString().padStart(2, '0') + ':' + now.getMinutes().toString().padStart(2, '0') + ':' + now.getSeconds().toString().padStart(2, '0');
    document.getElementById('time').innerText = formattedTime;
}

function updateDate() {
    const now = new Date();
    const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    const formattedDate = now.toLocaleDateString('it-IT', options);
    document.getElementById('datetime').innerText = formattedDate;
}

setInterval(updateClock, 1000);
updateClock();
updateDate();

function updateWeather() {
    const apiKey = 'de870caf7af382e9b4d36d76fc0ba75d';
    const cityId = '2523920';
    const url = `https://api.openweathermap.org/data/2.5/weather?id=${cityId}&appid=${apiKey}&units=metric&lang=it`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const cityName = data.name;
            const temp = data.main.temp;
            const humidity = data.main.humidity;
            const weatherDescription = data.weather[0].description;
            const sunrise = new Date(data.sys.sunrise * 1000);
            const sunset = new Date(data.sys.sunset * 1000);

            const formattedSunrise = sunrise.getHours().toString().padStart(2, '0') + ':' + sunrise.getMinutes().toString().padStart(2, '0');
            const formattedSunset = sunset.getHours().toString().padStart(2, '0') + ':' + sunset.getMinutes().toString().padStart(2, '0');

            document.getElementById('weather').innerText = `${temp.toFixed(1)}°C - umidità ${humidity}% - ${weatherDescription}`;
            document.getElementById('sunrise').innerText = `Alba: ${formattedSunrise}`;
            document.getElementById('sunset').innerText = `Tramonto: ${formattedSunset}`;

            document.getElementById('city').innerText = cityName;
        })
        .catch(error => console.error('Errore nel recupero dei dati meteo:', error));
}

updateWeather();
setInterval(updateWeather, 3600000);

function loadNextContent(url, idImpianto, idPalinsesto) {
    fetch(url)
        .then(response => response.text())
        .then(data => {
            const parser = new DOMParser();
            const xmlDoc = parser.parseFromString(data, 'text/xml');

            const elements = xmlDoc.getElementsByTagName('elemento');
            const palinsesto = [];
            for (let i = 0; i < elements.length; i++) {
                const durata = parseInt(elements[i].getAttribute('durata'));
                const file = elements[i].getElementsByTagName('file')[0].textContent;
                palinsesto.push({ durata, file });
            }

            let currentIndex = 0;
            function playNext() {
                const elemento = palinsesto[currentIndex];
                document.getElementById('content').innerHTML = `<object type="text/html" data="${elemento.file}" style="width:100%; height:calc(100vh - 60px);"></object>`;

                const filePath = palinsesto[currentIndex].file; // per estrarre il nome del cartellone
                const fileName = filePath.split("/").pop();

                fetch('../cartelloni.json')
                    .then(response => response.json())
                    .then(mapping => {
                        const idCartellone = mapping[fileName];
                        inviaSegnalazione(idImpianto, idPalinsesto, idCartellone, elemento.durata);
                    })
                    .catch(error => console.error('Errore nel caricamento del mapping:', error));


                currentIndex = (currentIndex + 1) % palinsesto.length;
                setTimeout(playNext, elemento.durata * 1000);
            }
            playNext();
        })
        .catch(error => console.error('Errore nel recupero del palinsesto:', error));
}

function inviaSegnalazione(idImpianto, idPalinsesto, idCartellone, durata) {
    const url = 'http://localhost:8000/monitoraggio_war_exploded/segnalazione';
    const data = {
        idImpianto: idImpianto,
        idPalinsesto: idPalinsesto,
        idCartellone: idCartellone,
        durata: durata
    };

    // async di default è uguale a true
    $.ajax({
        url: url,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function() {
            console.log('Segnalazione inviata con successo!');
        },
        error: function(xhr, status, error) {
            console.error('Errore durante l\'invio della segnalazione:', error);
        }
    });
}
