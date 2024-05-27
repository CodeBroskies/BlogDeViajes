package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Tipo;
import es.atlastrip.BlogDeViajes.services.TipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/tipos")
public class TipoController {

    TipoService service = new TipoService();

    @GetMapping("/listar")
    public String listar(@RequestParam Model model) throws SQLException {
        String busqueda = "";
        ArrayList<Tipo> tipos = service.listarTipos();
        model.addAttribute("tipos", service.listarTipos());
        model.addAttribute("tipo", new Tipo());
        model.addAttribute("busqueda", busqueda);
        return "tipos";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
        service.eliminarTipo(id);
        model.addAttribute("tipos", service.listarTipos());
        return "redirect:/tipos/listar?pagina=1";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("tipoSeleccionado", service.obtenerTipo(id));
        return "tipoModificar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Tipo tipo, Model model) throws SQLException {
        service.actualizarTipo(tipo);
        model.addAttribute("tipos", service.listarTipos());
        return "redirect:/tipos/listar?pagina=1";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Tipo tipo, Model model) throws SQLException {
        service.crearTipo(tipo);
        model.addAttribute("tipos", service.listarTipos());
        return "redirect:/tipos/listar?pagina=1";
    }
}
