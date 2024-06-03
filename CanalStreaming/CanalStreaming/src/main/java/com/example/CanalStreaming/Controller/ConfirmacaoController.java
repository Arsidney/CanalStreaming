package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/confirmacao")
public class ConfirmacaoController {

    private final UsuarioService usuarioService;

    @GetMapping
    public String confirmarCadastro(@RequestParam("token") String confirmationToken) {
        if (usuarioService.confirmarCadastro(confirmationToken)) {
            return "Seu cadastro foi confirmado com sucesso!";
        } else {
            return "Token de confirmação inválido ou expirado.";
        }
    }
}