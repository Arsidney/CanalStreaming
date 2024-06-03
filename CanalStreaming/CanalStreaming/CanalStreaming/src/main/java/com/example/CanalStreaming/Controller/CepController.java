package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.clients.ViaCepClient;
import com.example.CanalStreaming.Model.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private ViaCepClient viaCepClient;

    @GetMapping("/{cep}")
    public Endereco consultaCep(@PathVariable String cep){
        return viaCepClient.consultaEndereco(cep);
    }
}
