package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Palinsesto;
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

    @GetMapping("/wsda")
    public String handleQueryRequest(@RequestParam(name="id", required=false) String id, Model model) {
        //System.out.println("ID_ricevuto: " + id);

        if (id != null && !id.isEmpty()) {
            Palinsesto palinsesto = palinsestoService.getPalinsestoByIdImpianto(id);

            if (palinsesto != null) {
                model.addAttribute("idPalinsesto", palinsesto.getIdPalinsesto());
                model.addAttribute("idImpianto", id);

                return "view"; // restituisco la vista
            }
        }

        model.addAttribute("errorMessage", "Errore: Nessun palinsesto trovato per l'ID specificato.");
        return "errorView";
    }
}
