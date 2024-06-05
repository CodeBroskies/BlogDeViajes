package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Cliente;
import es.atlastrip.BlogDeViajes.models.Comentario;
import es.atlastrip.BlogDeViajes.models.Post;
import es.atlastrip.BlogDeViajes.models.Seccion;
import es.atlastrip.BlogDeViajes.services.ClienteService;
import es.atlastrip.BlogDeViajes.services.ComentarioService;
import es.atlastrip.BlogDeViajes.services.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class WebController {

    PostService service = new PostService();

    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("lastPosts", service.listarLastPostsVista());

        if (userDetails == null) {
            Cliente cliente = new Cliente();
            cliente.setAvatar("null");
            model.addAttribute("usuario", cliente);
        } else {
            model.addAttribute("usuario", new ClienteService().obtenerCliente(userDetails.getUsername()));
        }
        return "index";
    }

    @GetMapping("/posts")
    public String posts(@AuthenticationPrincipal UserDetails userDetails, @RequestParam(value = "busqueda", required = false) String busqueda, Model model) throws SQLException {
        if (busqueda == null) {
            busqueda = "";
            model.addAttribute("posts", service.listarPostsVista());
        } else {
            ArrayList<Post> posts = service.listarPostsVista(busqueda);
            if (posts.isEmpty()) {
                model.addAttribute("mensaje", "No se han encontrado publicaciones");
            } else {
                model.addAttribute("posts", posts);
            }
        }
        model.addAttribute("busqueda", busqueda);

        if (userDetails == null) {
            Cliente cliente = new Cliente();
            cliente.setAvatar("null");
            model.addAttribute("usuario", cliente);
        } else {
            model.addAttribute("usuario", new ClienteService().obtenerCliente(userDetails.getUsername()));
        }
        return "posts";
    }

    @GetMapping("/crearpost")
    public String crearpost(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        if (userDetails == null) {
            return "redirect:/login";
        }

        Post nuevoPost = new Post();

        nuevoPost.getSecciones().add(new Seccion());
        nuevoPost.getSecciones().add(new Seccion());
        nuevoPost.getSecciones().add(new Seccion());

        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("post", nuevoPost);

        model.addAttribute("usuario", new ClienteService().obtenerCliente(userDetails.getUsername()));
        return "createpost";
    }

    @GetMapping("/verpost")
    public String verpost(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("id") int id_post, Model model) throws SQLException {
        if (userDetails == null) {
            return "redirect:/login";
        }

        Post post = new PostService().obtenerPostCompleto(id_post);

        Comentario comentario = new Comentario();
        comentario.setId_post(id_post);

        model.addAttribute("post", post);
        model.addAttribute("creador", new ClienteService().obtenerCliente(post.getId_cliente()));
        model.addAttribute("comentarios", new ComentarioService().listarComentariosPorPost(id_post));
        model.addAttribute("comentario", comentario);

        model.addAttribute("usuario", new ClienteService().obtenerCliente(userDetails.getUsername()));
        return "post";
    }

    @GetMapping("/ajustes")
    public String settings(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("cliente", new ClienteService().obtenerCliente(userDetails.getUsername()));
        model.addAttribute("usuario", new ClienteService().obtenerCliente(userDetails.getUsername()));
        return "settings";
    }

    @PostMapping("/actualizarAjustes")
    public String actualizarAjustes(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute Cliente cliente, Model model) throws SQLException {
        System.out.println(cliente.getId());
        new ClienteService().actualizarCliente(cliente);
        model.addAttribute("cliente", new ClienteService().obtenerCliente(userDetails.getUsername()));
        model.addAttribute("usuario", new ClienteService().obtenerCliente(userDetails.getUsername()));
        return "settings";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("url", "dashboard");
        return "/admin/dashboard";
    }

    @GetMapping("/admin/clientes")
    public String tablaClientes(Model model) {
        model.addAttribute("url", "clientestabla");
        return "/admin/clientestabla";
    }

    @GetMapping("/admin/comentarios")
    public String tablaComentarios(Model model) {
        model.addAttribute("url", "comentariostabla");
        return "/admin/comentariostabla";
    }

    @GetMapping("/admin/posts")
    public String tablaPosts(Model model) {
        model.addAttribute("url", "poststabla");
        return "/admin/poststabla";
    }

    @GetMapping("/admin/secciones")
    public String tablaSecciones(Model model) {
        model.addAttribute("url", "seccionestabla");
        return "/admin/seccionestabla";
    }

    @GetMapping("/admin/tipos")
    public String tablaTipos(Model model) {
        model.addAttribute("url", "tipostabla");
        return "/admin/tipostabla";
    }

}