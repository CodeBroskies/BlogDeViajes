package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Cliente;
import es.atlastrip.BlogDeViajes.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService service = new ClienteService();

        @GetMapping("/listar")
        public String listar(@RequestParam Model model) throws SQLException {
            String busqueda = "";
            model.addAttribute("clientes", service.listarClientes());
            model.addAttribute("cliente", new Cliente());
            model.addAttribute("busqueda", busqueda);
            return "clientes";
        }

        @GetMapping("/eliminar")
        public String eliminar(@RequestParam("id") int id, Model model) throws SQLException {
            service.eliminarCliente(id);
            model.addAttribute("clientes", service.listarClientes());
            return "redirect:/clientes/listar?pagina=1";
        }

        @GetMapping("/modificar")
        public String modificar(@RequestParam("id") int id, Model model) throws SQLException {
            model.addAttribute("clienteSeleccionado", service.obtenerCliente(id));
            return "clienteModificar";
        }

        @PostMapping("/actualizar")
        public String actualizar(@ModelAttribute Cliente cliente, Model model) throws SQLException {
            service.actualizarCliente(cliente);
            model.addAttribute("clientes", service.listarClientes());
            return "redirect:/clientes/listar?pagina=1";
        }

        @PostMapping("/agregar")
        public String agregar(@ModelAttribute Cliente cliente, Model model) throws SQLException {
            service.crearCliente(cliente);
            model.addAttribute("clientes", service.listarClientes());
            return "redirect:/clientes/listar?pagina=1";
        }
}
