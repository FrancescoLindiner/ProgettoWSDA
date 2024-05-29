package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Service.ImpressioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}