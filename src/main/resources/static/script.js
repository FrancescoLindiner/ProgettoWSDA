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
            const cityName = data.name; // Aggiunto il nome della città
            const temp = data.main.temp;
            const humidity = data.main.humidity;
            const weatherDescription = data.weather[0].description;
            const sunrise = new Date(data.sys.sunrise * 1000);
            const sunset = new Date(data.sys.sunset * 1000);

            // Formatta l'orario di alba e tramonto come hh:mm
            const formattedSunrise = sunrise.getHours().toString().padStart(2, '0') + ':' + sunrise.getMinutes().toString().padStart(2, '0');
            const formattedSunset = sunset.getHours().toString().padStart(2, '0') + ':' + sunset.getMinutes().toString().padStart(2, '0');

            // Visualizza tutte le informazioni nella info-bar in italiano
            document.getElementById('weather').innerText = `${temp.toFixed(1)}°C - umidità ${humidity}% - ${weatherDescription}`;
            document.getElementById('sunrise').innerText = `Alba: ${formattedSunrise}`;
            document.getElementById('sunset').innerText = `Tramonto: ${formattedSunset}`;

            // Aggiungi il nome della città all'inizio dell'info-bar
            document.getElementById('city').innerText = cityName;
        })
        .catch(error => console.error('Errore nel recupero dei dati meteo:', error));
}

updateWeather();
setInterval(updateWeather, 3600000);

// Carica e esegue il palinsesto
function loadNextContent() {
    fetch('file_xml/palinsesto5.xml')
        .then(response => response.text())
        .then(data => {
            // Parse XML
            const parser = new DOMParser();
            const xmlDoc = parser.parseFromString(data, 'text/xml');

            // Estrai elementi dal documento XML
            const elements = xmlDoc.getElementsByTagName('elemento');
            const palinsesto = [];
            for (let i = 0; i < elements.length; i++) {
                const durata = parseInt(elements[i].getAttribute('durata'));
                const file = elements[i].getElementsByTagName('file')[0].textContent;
                palinsesto.push({ durata, file });
            }

            // Esegui il palinsesto
            let currentIndex = 0;
            function playNext() {
                const elemento = palinsesto[currentIndex];
                document.getElementById('content').innerHTML = `<object type="text/html" data="${elemento.file}" style="width:100%; height:calc(100vh - 60px);"></object>`;
                currentIndex = (currentIndex + 1) % palinsesto.length;
                setTimeout(playNext, elemento.durata * 1000);
            }
            playNext();
        })
        .catch(error => console.error('Errore nel recupero del palinsesto:', error));
}



loadNextContent();