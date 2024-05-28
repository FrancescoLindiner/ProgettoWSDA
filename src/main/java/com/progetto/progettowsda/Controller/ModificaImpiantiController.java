package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Model.Palinsesto;
import com.progetto.progettowsda.Service.ImpiantoService;
import com.progetto.progettowsda.Service.PalinsestoService;
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

    @Autowired
    private PalinsestoService palinsestoService;

    // 2) prendo il palinsesto associato all'id dell'impianto
    @GetMapping
    public String getAllImpianti(Model model) {
        List<Impianto> impianti = impiantoService.getAllImpianti();
        List<Palinsesto> palinsesti = palinsestoService.getAllPalinsesti();

        // Aggiungi la lista di impianti al modello
        model.addAttribute("impianti", impianti);
        model.addAttribute("palinsesti", palinsesti);

        return "impianti"; // Questo dovrebbe restituire il nome del template Thymeleaf (impianti.html)
    }
}
