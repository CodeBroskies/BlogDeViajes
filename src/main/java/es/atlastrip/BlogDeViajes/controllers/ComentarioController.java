package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Comentario;
import es.atlastrip.BlogDeViajes.services.ComentarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

    ComentarioService service = new ComentarioService();

    @GetMapping("/listar")
    public String listar(@RequestParam Model model) throws SQLException {
        String busqueda = "";
        model.addAttribute("comentarios", service.listarComentarios());
        model.addAttribute("comentario", new Comentario());
        model.addAttribute("busqueda", busqueda);
        return "comentarios";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
        service.eliminarComentario(id);
        model.addAttribute("comentarios", service.listarComentarios());
        return "redirect:/comentarios/listar";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("comentarioSeleccionado", service.obtenerComentario(id));
        return "comentarioModificar";
    }

    @PutMapping("/actualizar")
    public String actualizar(@ModelAttribute Comentario comentario, Model model) throws SQLException {
        service.actualizarComentario(comentario);
        model.addAttribute("comentarios", service.listarComentarios());
        return "redirect:/comentarios/listar";
    }

    @PostMapping("/agregar")
    public String agregar(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute Comentario comentario, Model model) throws SQLException {
        service.crearComentario(userDetails, comentario);
        model.addAttribute("comentarios", service.listarComentarios());
        return "redirect:/verpost?id=" + comentario.getId_post();
    }

}
