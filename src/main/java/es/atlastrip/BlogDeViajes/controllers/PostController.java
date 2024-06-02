package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Comentario;
import es.atlastrip.BlogDeViajes.models.Post;
import es.atlastrip.BlogDeViajes.models.Seccion;
import es.atlastrip.BlogDeViajes.models.Tipo;
import es.atlastrip.BlogDeViajes.services.ClienteService;
import es.atlastrip.BlogDeViajes.services.PostService;
import es.atlastrip.BlogDeViajes.services.SeccionService;
import es.atlastrip.BlogDeViajes.services.TipoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final TipoService tipoService;
    PostService postService = new PostService();
    SeccionService seccionService = new SeccionService();

    public PostController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping("/listar")
    public String listar(@RequestParam Model model) throws SQLException {
        String busqueda = "";
        model.addAttribute("posts", postService.listarPosts());
        model.addAttribute("post", new Post());
        model.addAttribute("busqueda", busqueda);
        return "posts";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
        postService.eliminarPost(id);
        model.addAttribute("posts", postService.listarPosts());
        return "redirect:/posts/listar";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("postSeleccionado", postService.obtenerPost(id));
        return "postModificar";
    }

    @PutMapping("/actualizar")
    public String actualizar(@ModelAttribute Post post, Model model) throws SQLException {
        postService.actualizarPost(post);
        model.addAttribute("posts", postService.listarPosts());
        return "redirect:/posts/listar";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Post post, Model model) throws SQLException {
        postService.crearPost(post);
        model.addAttribute("posts", postService.listarPosts());
        return "redirect:/posts/listar";
    }

    @PostMapping("/crear")
    public String crear(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute("post") Post post, Model model) throws SQLException {
        post.setId_cliente(new ClienteService().obtenerCliente(userDetails.getUsername()).getId());
        int nuevoPostId = postService.crearPost(post);
        for (Seccion seccion : post.getSecciones()) {
            seccion.setId_post(nuevoPostId);
            if (!seccion.getContenido().isEmpty() && seccion.getUrl_image() != null) {
                int nuevaSeccionId = seccionService.crearSeccion(seccion);
                int nuevoTipoId = tipoService.crearTipo(new Tipo("Contenido", seccion.getContenido(), seccion.getUrl_image()));
                tipoService.crearTipoSeccion(nuevaSeccionId, nuevoTipoId);
            }
        }
        model.addAttribute("posts", postService.listarPostsVista());
        return "redirect:/post";
    }
}
