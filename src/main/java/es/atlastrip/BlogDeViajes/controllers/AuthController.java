package es.atlastrip.BlogDeViajes.controllers;

import es.atlastrip.BlogDeViajes.models.Cliente;
import es.atlastrip.BlogDeViajes.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegisterView(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(Cliente cliente) throws SQLException {
        new ClienteService().crearCliente(cliente);
        return "redirect:/login";
    }
}