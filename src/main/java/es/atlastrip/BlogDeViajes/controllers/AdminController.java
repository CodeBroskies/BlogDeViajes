package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Cliente;
import es.atlastrip.BlogDeViajes.models.Comentario;
import es.atlastrip.BlogDeViajes.services.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {

    ClienteService clienteService = new ClienteService();
    ComentarioService comentarioService = new ComentarioService();
    PostService postService = new PostService();
    SeccionService seccionService = new SeccionService();
    TipoService tipoService = new TipoService();

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "dashboard");

        model.addAttribute("clientesTotales", clienteService.contarClientes());
        model.addAttribute("postsTotales", postService.contarPosts());
        model.addAttribute("comentariosTotales", comentarioService.contarComentarios());
        model.addAttribute("labels", comentarioService.obtenerLabelsParaGrafico());
        model.addAttribute("data", comentarioService.obtenerDataParaGrafico());

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/dashboard";
    }

    @GetMapping("/clientes")
    public String tablaClientes(@RequestParam(value = "pagina", defaultValue = "1") int pagina, @AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "clientestabla");

        String busqueda = "";
        ArrayList<Cliente> clientes = clienteService.listarClientes(pagina);
        int paginas = ((clientes.size()%5) == 0) ? clientes.size()/5 : (clientes.size() < 5) ? 1 : (clientes.size()/5 + 1);
        model.addAttribute("clientes", clienteService.listarClientes(pagina));
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("busqueda", busqueda);
        model.addAttribute("pagina", pagina);
        model.addAttribute("paginas", paginas);

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/clientestabla";
    }

    @GetMapping("/clientes/ordenar")
    public String tablaClientes(@RequestParam(value = "pagina", defaultValue = "1") int pagina, @RequestParam("columna") String columna, @RequestParam("orden") String orden, @AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "clientestabla");

        String busqueda = "";
        ArrayList<Cliente> clientes = clienteService.listarClientes(pagina);
        int paginas = ((clientes.size()%5) == 0) ? clientes.size()/5 : (clientes.size() < 5) ? 1 : (clientes.size()/5 + 1);
        model.addAttribute("clientes", clienteService.ordenarClientes(pagina, columna, orden));
        model.addAttribute("columna", columna);
        model.addAttribute("orden", orden);
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("pagina", pagina);
        model.addAttribute("paginas", paginas);

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/clientestabla";
    }

    @GetMapping("/clientes/buscar")
    public String buscarUsuarios(@RequestParam("busqueda") String busqueda, @RequestParam("filtro") String filtro, @AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "clientestabla");

        model.addAttribute("clientes", clienteService.filtrarUsuarios(busqueda, filtro));
        model.addAttribute("cliente", new Cliente());

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/clientestabla";
    }

    @GetMapping("/comentarios")
    public String tablaComentarios(@RequestParam(value = "pagina", defaultValue = "1") int pagina, @AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "comentariostabla");

        String busqueda = "";
        ArrayList<Comentario> comentarios = comentarioService.listarComentarios(pagina);
        int paginas = ((comentarios.size()%5) == 0) ? comentarios.size()/5 : (comentarios.size() < 5) ? 1 : (comentarios.size()/5 + 1);
        model.addAttribute("comentarios", comentarioService.listarComentarios(pagina));
        model.addAttribute("comentario", new Comentario());
        model.addAttribute("busqueda", busqueda);
        model.addAttribute("pagina", pagina);
        model.addAttribute("paginas", paginas);

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/comentariostabla";
    }

    @GetMapping("/posts")
    public String tablaPosts(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "poststabla");

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/poststabla";
    }

    @GetMapping("/secciones")
    public String tablaSecciones(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "seccionestabla");

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/seccionestabla";
    }

    @GetMapping("/tipos")
    public String tablaTipos(@AuthenticationPrincipal UserDetails userDetails, Model model) throws SQLException {
        model.addAttribute("url", "tipostabla");

        model.addAttribute("usuario", clienteService.obtenerCliente(userDetails.getUsername()));
        return "/admin/tipostabla";
    }
}
