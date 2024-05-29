function aggiungiRiga(idImpianto, descrizione, stato, latitudine, longitudine, palinsesto_path, palinsesti) {
    var tbody = $("#corpo-tabella");
    var newRow = $("<tr>");

    newRow.append("<td><span>" + idImpianto + "</span></td>"); // Utilizzo di <span> anziché <input>
    newRow.append("<td><input type='text' value='" + descrizione + "'></td>");

    // Creare il select per il palinsesto
    var select = $("<select>");

    // Aggiungi l'opzione predefinita
    var defaultOption = $("<option>").text(palinsesto_path).val(palinsesto_path).prop('selected', true);
    select.append(defaultOption);

    // Itera sui palinsesti e aggiungi le opzioni
    palinsesti.forEach(function(palinsesto) {
        if (palinsesto.idPalinsesto !== palinsesto_path) {
            var option = $("<option>").text(palinsesto.idPalinsesto).val(palinsesto.idPalinsesto);
            select.append(option);
        }
    });

    newRow.append($("<td>").append(select));

    // Se lo stato è true, il radio button viene selezionato
    if (stato) {
        newRow.append("<td><input type='checkbox' value='true' checked></td>");
    } else {
        newRow.append("<td><input type='checkbox' value='false'></td>");
    }
    newRow.append("<td><input type='text' value='" + latitudine + "'></td>");
    newRow.append("<td><input type='text' value='" + longitudine + "'></td>");

    tbody.append(newRow);
}

function showToast(message, isSuccess) {
    var toast = document.getElementById("toast");
    toast.className = "toast show " + (isSuccess ? "success" : "error");
    toast.textContent = message;
    setTimeout(function() {
        toast.className = toast.className.replace("show", "");
    }, 3000);
}