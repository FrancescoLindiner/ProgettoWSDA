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

    @GetMapping("/getId")
    public String handleQueryRequest(@RequestParam("id") String id, Model model) {
        System.out.println("ID_ricevuto: " + id);

        Palinsesto palinsesto = palinsestoService.getPalinsestoByIdImpianto(id);

        System.out.println(palinsesto.getIdPalinsesto());

        model.addAttribute("palinsesto", palinsesto);

        return "nomeDellaVista";
    }
}
