// Funzione per aggiungere opzioni a un select
function addOptionsToSelect(impianti, palinsesti, cartelloni) {
    var selectIdImpianto = $("#idImpianto");
    var selectIdPalinsesto = $("#idPalinsesto")
    var selectIdCartellone = $("#idCartellone")

    impianti.forEach(function(impianto) {
        var option = $("<option>").text(impianto)
        selectIdImpianto.append(option);
    });

    let defaultOption = $("<option>").text("-").prop('selected', true);
    selectIdPalinsesto.append(defaultOption);

    palinsesti.forEach(function(palinsesto) {
        var option = $("<option>").text(palinsesto)
        selectIdPalinsesto.append(option);

    });

    let defaultOptionCartellone = $("<option>").text("-").prop('selected', true);
    selectIdCartellone.append(defaultOptionCartellone)

    cartelloni.forEach(function(cartellone) {
        var option = $("<option>").text(cartellone)
        selectIdCartellone.append(option);
    });
}