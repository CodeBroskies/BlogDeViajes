package es.atlastrip.BlogDeViajes.controllers;

import org.springframework.stereotype.Controller;
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
    public String crearpost() {
        return "createpost";
    }

    @GetMapping("/verpost")
    public String verpost() {
        return "post";
    }

}