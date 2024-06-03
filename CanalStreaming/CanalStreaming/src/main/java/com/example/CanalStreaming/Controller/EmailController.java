package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.DTO.EmailDTO;
import com.example.CanalStreaming.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar-email")
    public String enviarEmail(@RequestBody EmailDTO emailDTO) {
        emailService.enviarEmailConfirmacao(emailDTO.getDestinatario(), emailDTO.getAssunto(), emailDTO.getMensagem());
        return "E-mail enviado com sucesso.";
    }
}
