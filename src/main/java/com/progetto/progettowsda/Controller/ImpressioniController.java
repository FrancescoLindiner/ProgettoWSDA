package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Model.Palinsesto;
import com.progetto.progettowsda.Service.ImpiantoService;
import com.progetto.progettowsda.Service.ImpressioniService;
import com.progetto.progettowsda.Service.PalinsestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ImpressioniController {

    @Autowired
    private ImpressioniService impressioniService;

    @Autowired
    private ImpiantoService impiantoService;

    @Autowired
    private PalinsestoService palinsestoService;

    @GetMapping("/report")
    public String searchImpression(
            @RequestParam(required = false) String idImpianto,
            @RequestParam(required = false) String idPalinsesto,
            @RequestParam(required = false) String idCartellone,
            @RequestParam(required = false) LocalDateTime timestampFrom,
            Model model) {
        // Chiamata al servizio per ottenere i dati filtrati
        List<Object[]> impressione = impressioniService.searchImpressions(idImpianto, idPalinsesto, idCartellone, timestampFrom);
        System.out.println(impressione);
        model.addAttribute("impressione", impressione);
        return "report";
    }

    @GetMapping("/impression")
    public String impression(Model model) {
        List<Impianto> impianti = impiantoService.getAllImpianti();
        List<Palinsesto> palinsesti = palinsestoService.getAllPalinsesti();

        model.addAttribute("impianti", impianti);
        model.addAttribute("palinsesti", palinsesti);

        return "impressioni_view";
    }
}
