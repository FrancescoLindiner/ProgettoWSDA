package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Service.ImpressioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ImpressioniController {

    @Autowired
    private ImpressioniService impressioniService;

    @GetMapping("/report")
    public String showReportPage(Model model) {
        List<Object []> impressione = impressioniService.getAllImpressions();
        model.addAttribute("impressione", impressione);
        return "report";
    }

    @PostMapping("/aggiorna")
    public String aggiornaImpianto(@RequestParam String idImpianto, @RequestParam String descrizione,
                                   @RequestParam boolean stato, @RequestParam float latitudine,
                                   @RequestParam float longitudine) {
        impressioniService.aggiornaImpianto(idImpianto, descrizione, stato, latitudine, longitudine);
        return "messaggio";
    }

}