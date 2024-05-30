package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Post;
import es.atlastrip.BlogDeViajes.services.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class WebController {

    PostService service = new PostService();

    @GetMapping("/")
    public String index(Model model) throws SQLException {
        model.addAttribute("lastPosts", service.listarLastPostsVista());
        return "index";
    }

    @GetMapping("/post")
    public String posts(Model model) throws SQLException {
        String busqueda = "";
        model.addAttribute("posts", service.listarPostsVista());
        model.addAttribute("busqueda", busqueda);
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