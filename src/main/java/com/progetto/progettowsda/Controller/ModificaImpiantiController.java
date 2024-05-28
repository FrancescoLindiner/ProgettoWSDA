package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Service.ImpiantoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/impianti")
public class ModificaImpiantiController {
    @Autowired
    private ImpiantoService impiantoService;

    @GetMapping
    public String getAllImpianti(Model model) {
        List<Impianto> impianti = impiantoService.getAllImpianti();

        // Aggiungi la lista di impianti al modello
        model.addAttribute("impianti", impianti);

        return "impianti"; // Questo dovrebbe restituire il nome del template Thymeleaf (impianti.html)
    }
}
