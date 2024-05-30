package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Seccion;
import es.atlastrip.BlogDeViajes.services.SeccionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/seccions")
public class SeccionController {

    SeccionService service = new SeccionService();

    @GetMapping("/listar")
    public String listar(@RequestParam Model model) throws SQLException {
        String busqueda = "";
        model.addAttribute("seccions", service.listarSeccions());
        model.addAttribute("seccion", new Seccion());
        model.addAttribute("busqueda", busqueda);
        return "seccions";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
        service.eliminarSeccion(id);
        model.addAttribute("seccions", service.listarSeccions());
        return "redirect:/seccions/listar?pagina=1";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("seccionSeleccionado", service.obtenerSeccion(id));
        return "seccionModificar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Seccion seccion, Model model) throws SQLException {
        service.actualizarSeccion(seccion);
        model.addAttribute("seccions", service.listarSeccions());
        return "redirect:/seccions/listar?pagina=1";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Seccion seccion, Model model) throws SQLException {
        service.crearSeccion(seccion);
        model.addAttribute("seccions", service.listarSeccions());
        return "redirect:/seccions/listar?pagina=1";
    }
}
