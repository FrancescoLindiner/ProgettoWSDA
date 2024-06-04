function aggiungiRiga(idImpianto, descrizione, stato, latitudine, longitudine, palinsesto_path, palinsesti) {
    var tbody = $("#corpo-tabella");
    var newRow = $("<tr>");

    newRow.append("<td><span>" + idImpianto + "</span></td>");
    newRow.append("<td><input type='text' value='" + descrizione + "'></td>");

    var select = $("<select>");

    var defaultOption = $("<option>").text(palinsesto_path).val(palinsesto_path).prop('selected', true);
    select.append(defaultOption);

    palinsesti.forEach(function(palinsesto) {
        if (palinsesto.idPalinsesto !== palinsesto_path) {
            var option = $("<option>").text(palinsesto.idPalinsesto).val(palinsesto.idPalinsesto);
            select.append(option);
        }
    });

    newRow.append($("<td>").append(select));

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