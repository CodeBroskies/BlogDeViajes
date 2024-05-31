package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Comentario;
import es.atlastrip.BlogDeViajes.models.Post;
import es.atlastrip.BlogDeViajes.models.Seccion;
import es.atlastrip.BlogDeViajes.models.Tipo;
import es.atlastrip.BlogDeViajes.services.ClienteService;
import es.atlastrip.BlogDeViajes.services.ComentarioService;
import es.atlastrip.BlogDeViajes.services.PostService;
import es.atlastrip.BlogDeViajes.services.SeccionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

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

        Post nuevoPost = new Post();

        nuevoPost.getSecciones().add(new Seccion());
        nuevoPost.getSecciones().add(new Seccion());
        nuevoPost.getSecciones().add(new Seccion());

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("post", nuevoPost);
        return "createpost";
    }

    @GetMapping("/verpost")
    public String verpost(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("id") int id_post, Model model) throws SQLException {
        if (userDetails == null) {
            return "redirect:/login";
        }

        Post post = new PostService().obtenerPost(id_post);

        Comentario comentario = new Comentario();
        comentario.setId_post(id_post);

        model.addAttribute("post", post);
        model.addAttribute("usuario", new ClienteService().obtenerCliente(post.getId_cliente()));
        model.addAttribute("secciones", new SeccionService().listarContenidoPorPost(id_post));
        model.addAttribute("comentarios", new ComentarioService().listarComentariosPorPost(id_post));
        model.addAttribute("comentario", comentario);

        return "post";
    }

}