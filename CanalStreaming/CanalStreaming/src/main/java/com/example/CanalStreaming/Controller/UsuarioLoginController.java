package com.example.CanalStreaming.Controller;


import com.example.CanalStreaming.Model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Controller
@RequestMapping("/UsuarioLogin")
public class UsuarioLoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("cpf", "");
        model.addAttribute("password", "");
        return "login";
    }

    @PostMapping("/login")
    public String login(Usuario usuario) {
        // Lógica de autenticação aqui
        return "redirect:/"; // Redirecionar após o login
    }
}


