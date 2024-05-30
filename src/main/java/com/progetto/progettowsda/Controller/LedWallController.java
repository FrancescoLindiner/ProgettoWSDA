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


    @GetMapping("/wsda")
    public String handleQueryRequest(@RequestParam(name="id", required=false) String id, Model model) {
        // devo verificare se l'impianto è attivo

        Boolean isImpiantoAttivo = impiantoService.isAttivo(id).isStato();

        if (!isImpiantoAttivo) {
            return "error";
        }

        if (!id.isEmpty()) {
            Impianto impianto = impiantoService.getPalinsestoByIdImpianto(id);

            model.addAttribute("idPalinsesto", impianto.getIdPalinsesto());
            model.addAttribute("pathPalinsesto", impianto.getPalinsesto_path());
            model.addAttribute("idImpianto", id);

            return "view";
        }
        return "error";
    }

    @GetMapping("/segnala_stato")
    public String segnalaStato(@RequestParam(name = "id") String idImpianto,
                               @RequestParam(name = "stato") boolean stato) {
        impiantoService.aggiornaStato(idImpianto, stato);
        return "messaggio";
    }
}
