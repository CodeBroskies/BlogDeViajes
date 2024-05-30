package es.atlastrip.BlogDeViajes.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/post")
    public String posts() {
        return "posts";
    }

    @GetMapping("/crearpost")
    public String crearpost(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", userDetails.getUsername());
        return "createpost";
    }

    @GetMapping("/verpost")
    public String verpost() {
        return "post";
    }

}