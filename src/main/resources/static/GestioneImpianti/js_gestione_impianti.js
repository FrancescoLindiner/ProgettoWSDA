function aggiungiRiga(idImpianto, descrizione, stato, latitudine, longitudine, palinsesto) {
    var tbody = $("#corpo-tabella");
    var newRow = $("<tr>");

    newRow.append("<td><input type='text' value='" + idImpianto + "'></td>");
    newRow.append("<td><input type='text' value='" + descrizione + "'></td>");

    // Se lo stato è true, il radio button viene selezionato
    if (stato) {
        newRow.append("<td><input type='radio' value='" + stato + "' checked></td>");
    } else {
        newRow.append("<td><input type='radio' value='" + stato + "'></td>");
    }

    newRow.append("<td><input type='text' value='" + latitudine + "'></td>");
    newRow.append("<td><input type='text' value='" + longitudine + "'></td>");
    newRow.append("<td><input type='text' value='" + palinsesto + "'></td>");

    tbody.append(newRow);
}