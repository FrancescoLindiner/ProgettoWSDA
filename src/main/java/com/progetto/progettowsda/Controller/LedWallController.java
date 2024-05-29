package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Service.ImpiantoService;
import com.progetto.progettowsda.Service.PalinsestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LedWallController {

    @Autowired
    private PalinsestoService palinsestoService;

    @Autowired
    private ImpiantoService impiantoService;


    @GetMapping("/wsda")
    public String handleQueryRequest(@RequestParam(name="id", required=false) String id, Model model) {
        //System.out.println("ID_ricevuto: " + id);

        // devo prendere l'id del palinsesto associato all'impianto id
        if (id != null && !id.isEmpty()) {
            System.out.println(id);
            Impianto impianto = impiantoService.getPalinsestoByIdImpianto(id);

            if (impianto != null) {
                System.out.println("IDPALINSESTO" + impianto.getPalinsesto_path());
                model.addAttribute("idPalinsesto", impianto.getPalinsesto_path());
                System.out.println("IDPALINSESTO" + impianto.getPalinsesto_path());
                model.addAttribute("idImpianto", id);

                return "view"; // restituisco la vista
            }
        }

        model.addAttribute("errorMessage", "Errore: Nessun palinsesto trovato per l'ID specificato.");
        return "errorView";
    }

    @GetMapping("/segnala_stato")
    public String segnalaStato(@RequestParam(name = "idImpianto") String idImpianto,
                               @RequestParam(name = "stato") boolean stato, Model model) {


        return null;
    }
}
