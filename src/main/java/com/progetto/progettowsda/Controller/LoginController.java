package com.progetto.progettowsda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
    @GetMapping("/login") // login personalizzato
    String login() {
        return "login";
    }
}