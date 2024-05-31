// Funzione per aggiungere opzioni a un select
function addOptionsToSelect(impianti, palinsesti) {
    var selectIdImpianto = $("#idImpianto");
    var selectIdPalinsesto = $("#idPalinsesto")

    // Itera attraverso l'array di opzioni
    impianti.forEach(function(impianto) {
        // Crea un nuovo elemento option
        var option = $("<option>").text(impianto)
        selectIdImpianto.append(option);
    });

    var defaultOption = $("<option>").text("-").prop('selected', true);
    selectIdPalinsesto.append(defaultOption);

    palinsesti.forEach(function(palinsesto) {
        var option = $("<option>").text(palinsesto)
        selectIdPalinsesto.append(option);

    });
}