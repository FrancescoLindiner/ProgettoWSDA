package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Service.ImpiantoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LedWallController {

    @Autowired
    private ImpiantoService impiantoService;


    /**
     * metodo per gestire le richieste GET che vengono fatte dagli impianti
     * **/
    @GetMapping("/wsda")
    public String handleQueryRequest(@RequestParam(name="id", required=false) String id, Model model) {
        Impianto impianto = impiantoService.getPalinsestoByIdImpianto(id);
            if (impianto != null && impianto.isStato()) { // se non trovo l'impianto ritorno la schermata di errore nera
                model.addAttribute("idPalinsesto", impianto.getIdPalinsesto()); // prendo l'id del palinsesto associato all'impianto
                model.addAttribute("pathPalinsesto", impianto.getPalinsesto_path()); // prendo il path del palinsesto
                model.addAttribute("idImpianto", id);
                return "view";
            } else {
                return "error"; // schermata nera
            }
    }

    /**
     * metodo che è rimasto che ho dimenticato di cancellare
     * **/
    @GetMapping("/segnala_stato")
    public String segnalaStato(@RequestParam(name = "id") String idImpianto,
                               @RequestParam(name = "stato") boolean stato) {
        impiantoService.aggiornaStato(idImpianto, stato);
        return "messaggio";
    }
}
