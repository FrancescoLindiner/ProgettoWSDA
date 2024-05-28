function aggiungiRiga(idImpianto, descrizione, stato, latitudine, longitudine, palinsesti) {
    var tbody = $("#corpo-tabella");
    var newRow = $("<tr>");

    newRow.append("<td><input type='text' value='" + idImpianto + "'></td>");
    newRow.append("<td><input type='text' value='" + descrizione + "'></td>");

    // Creare il select per il palinsesto
    var select = $("<select>");

    // Itero sui palinsesti e controllo se l'idImpianto, ricavato dalla tabella "palinsesto", è uguale a idImpianto, ricavato dalla tabella Impianti
    palinsesti.forEach(function(palinsesto) {
        var option = $("<option>").text(palinsesto.idPalinsesto).val(palinsesto.idPalinsesto);
        // Imposta l'opzione predefinita se l'idPalinsesto corrisponde all'idImpianto
        if (palinsesto.idImpianto === idImpianto) {
            option.attr('selected', 'selected');
        }
        select.append(option);
    });
    newRow.append($("<td>").append(select));

    // Se lo stato è true, il radio button viene selezionato
    if (stato) {
        newRow.append("<td><input type='radio' value='true' checked></td>");
    } else {
        newRow.append("<td><input type='radio' value='false'></td>");
    }
    newRow.append("<td><input type='text' value='" + latitudine + "'></td>");
    newRow.append("<td><input type='text' value='" + longitudine + "'></td>");

    tbody.append(newRow);
}
