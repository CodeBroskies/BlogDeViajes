package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Post;
import es.atlastrip.BlogDeViajes.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class PostController {


    @Controller
    @RequestMapping("/posts")
    public class ControladorPost {

        PostService service = new PostService();

        @GetMapping("/listar")
        public String listar(@RequestParam Model model) throws SQLException {
            String busqueda = "";
            ArrayList<Post> posts = service.listarPosts();
            model.addAttribute("posts", service.listarPosts());
            model.addAttribute("post", new Post());
            model.addAttribute("busqueda", busqueda);
            return "posts";
        }

        @GetMapping("/eliminar")
        public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
            service.eliminarPost(id);
            model.addAttribute("posts", service.listarPosts());
            return "redirect:/posts/listar?pagina=1";
        }

        @GetMapping("/modificar")
        public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
            model.addAttribute("postSeleccionado", service.obtenerPost(id));
            return "postModificar";
        }

        @PostMapping("/actualizar")
        public String actualizar(@ModelAttribute Post post, Model model) throws SQLException {
            service.actualizarPost(post);
            model.addAttribute("posts", service.listarPosts());
            return "redirect:/posts/listar?pagina=1";
        }

        @PostMapping("/agregar")
        public String agregar(@ModelAttribute Post post, Model model) throws SQLException {
            service.crearPost(post);
            model.addAttribute("posts", service.listarPosts());
            return "redirect:/posts/listar?pagina=1";
        }

    }
}
