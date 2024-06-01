package com.progetto.progettowsda.Controller;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Model.ImpressioneDTO;
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
            @RequestParam(required = false) LocalDateTime timestampTo,
            Model model) {
        List<ImpressioneDTO> impressione;
        // idImpianto e idPalinsesto ci sono sempre
        System.out.println(idPalinsesto);
        if (idPalinsesto.equals("-")) {
                impressione = impressioniService.searchImpianto(idImpianto);
        } else if (idCartellone.isEmpty() && timestampTo==null && timestampFrom==null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsesto(idImpianto, idPalinsesto);
        } else if(!idCartellone.isEmpty() && timestampTo==null && timestampFrom==null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsestoIdCartellone(idImpianto, idPalinsesto, idCartellone);
        } else if(idCartellone.isEmpty() && timestampTo!=null && timestampFrom==null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsestoDateTo(idImpianto, idPalinsesto, timestampTo);
        } else if(!idCartellone.isEmpty() && timestampTo!=null && timestampFrom==null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsestoIdCartelloneDateTo(idImpianto, idPalinsesto, idCartellone, timestampTo);
        } else if(idCartellone.isEmpty() && timestampTo==null && timestampFrom!=null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsestoDateFrom(idImpianto, idPalinsesto, timestampFrom);
        } else if(!idCartellone.isEmpty() && timestampTo==null && timestampFrom!=null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsestoIdCartelloneDateFrom(idImpianto, idPalinsesto, idCartellone, timestampFrom);
        } else if(idCartellone.isEmpty() && timestampTo!=null && timestampFrom!=null) {
            impressione = impressioniService.searchIdImpiantoIdPalinsestoDate(idImpianto, idPalinsesto, timestampTo, timestampFrom);
        } else {
            impressione = impressioniService.searchAll(idImpianto, idPalinsesto, idCartellone, timestampFrom, timestampTo);
        }

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

    @GetMapping("/query-personalizzate")
    public String query_personalizzate(@RequestParam String query, Model model) {
        if (query.equals("query1")) {
            List<ImpressioneDTO> impressione = impressioniService.getImpiantoAttivo();
            model.addAttribute("impressione", impressione);
            model.addAttribute("query", query);
            return "query_personalizzata";
        } else if (query.equals("query2")) {
            List<ImpressioneDTO> impressione = impressioniService.getPalinsestoAttivo();
            model.addAttribute("impressione", impressione);
            model.addAttribute("query", query);
            return "query_personalizzata";
        } else {
            List<ImpressioneDTO> impressione = impressioniService.getCartelloneAttivo();
            model.addAttribute("impressione", impressione);
            model.addAttribute("query", query);
            return "query_personalizzata";
        }
    }
}
