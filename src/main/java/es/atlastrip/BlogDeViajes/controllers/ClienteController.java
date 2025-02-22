package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Cliente;
import es.atlastrip.BlogDeViajes.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService service = new ClienteService();

    @GetMapping("/listar")
    public String listar(Model model) throws SQLException {
        model.addAttribute("clientes", service.listarClientes());
        return "clientes";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
        service.eliminarCliente(id);
        model.addAttribute("clientes", service.listarClientes());
        return "redirect:/admin/clientes";
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
        model.addAttribute("clienteSeleccionado", service.obtenerCliente(id));
        return "clienteModificar";
    }

    @PutMapping("/actualizar")
    public String actualizar(@ModelAttribute Cliente cliente, Model model) throws SQLException {
        service.actualizarCliente(cliente);
        model.addAttribute("clientes", service.listarClientes());
        return "redirect:/admin/clientes";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Cliente cliente, Model model) throws SQLException {
        service.crearCliente(cliente);
        model.addAttribute("clientes", service.listarClientes());
        return "redirect:/admin/clientes";
    }
}
