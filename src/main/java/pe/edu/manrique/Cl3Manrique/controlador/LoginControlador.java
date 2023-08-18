package pe.edu.manrique.Cl3Manrique.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {

    @GetMapping("/login")
    public String mostrarPaginaLogin() {
        return "login"; // Esto asume que tu página de login se llama "login.html"
    }
}
