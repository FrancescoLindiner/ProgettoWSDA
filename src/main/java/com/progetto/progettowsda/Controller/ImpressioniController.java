package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Service.ImpressioniService;
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


    @GetMapping("/report")
    public String searchImpression(
            @RequestParam(required = false) String idImpianto,
            @RequestParam(required = false) String idPalinsesto,
            @RequestParam(required = false) String idCartellone,
            @RequestParam(required = false) Long durata,
            @RequestParam(required = false) LocalDateTime timestampFrom,
            Model model) {
        // Chiamata al servizio per ottenere i dati filtrati
        List<Object[]> impressione = impressioniService.searchImpressions(idImpianto, idPalinsesto, idCartellone, durata, timestampFrom);
        System.out.println(impressione);
        model.addAttribute("impressione", impressione);
        return "report";
    }
}
