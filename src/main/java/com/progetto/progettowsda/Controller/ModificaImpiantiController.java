package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Model.Palinsesto;
import com.progetto.progettowsda.Service.ImpiantoService;
import com.progetto.progettowsda.Service.PalinsestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ModificaImpiantiController {

    @Autowired
    private ImpiantoService impiantoService;

    @Autowired
    private PalinsestoService palinsestoService;

    @GetMapping("/impianti")
    public String getAllImpianti(Model model) {
        List<Impianto> impianti = impiantoService.getAllImpianti();
        List<Palinsesto> palinsesti = palinsestoService.getAllPalinsesti();

        model.addAttribute("palinsesti", palinsesti);
        model.addAttribute("impianti", impianti);

        return "impianti";
    }

    @PostMapping("/aggiorna")
    public String aggiornaImpianto(@RequestParam String idImpianto, @RequestParam String descrizione,
                                   @RequestParam boolean stato, @RequestParam float latitudine,
                                   @RequestParam float longitudine, Model model) {
        Boolean isUpdated = impiantoService.aggiornaImpianto(idImpianto, descrizione, stato, latitudine, longitudine);
        model.addAttribute("isUpdated", isUpdated);
        return "messaggio";
    }

    @PostMapping("/aggiorna_palinsesto")
    public String aggiornaImpiantoPalinsesto(@RequestParam String idImpianto, @RequestParam String idPalinsesto, Model model) {

        Boolean isUpdated = impiantoService.aggiornaImpiantoPalinsesto(idImpianto, idPalinsesto);
        model.addAttribute("isUpdated", isUpdated);
        return "messaggio";
    }

    @PostMapping("/aggiungi_impianto")
    public String aggiungiImpianto(@RequestParam String idImpianto,
                                   @RequestParam String descrizione,
                                   @RequestParam float latitudine,
                                   @RequestParam float longitudine,
                                   @RequestParam String palinsesto) {
        String palinsesto_path = "../../file_xml/palinsesto" + palinsesto + ".xml";
        impiantoService.aggiungiImpianto(idImpianto, descrizione, latitudine, longitudine, palinsesto_path, false);

        return "messaggio"; // Qui "impianto_aggiunto" è il nome della vista da caricare dopo l'aggiunta dell'impianto
    }
}
