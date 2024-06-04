package com.example.CanalStreaming.controller;


import com.example.CanalStreaming.model.Cartao;
import com.example.CanalStreaming.service.CartaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cartao")
public class CartaoController {

    private CartaoService cartaoService;

    @PostMapping("/Registrar")
    public Cartao registrar(@RequestBody Cartao cartao){

        return cartaoService.registrar(cartao);
    }

    @PutMapping("/Atualizar")
    public Cartao atualizar(@RequestBody Cartao cartao, @RequestParam String senha) {
        return cartaoService.atualizar(cartao, senha);
    }


    @GetMapping("Lista")
    public List<Cartao> listarTodos(){

        return cartaoService.listarTodos();
    }

    @GetMapping("/{id}/Buscar")
    public Cartao buscarPorId(@PathVariable Integer id){

        return cartaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}/Deletar")
    public void excluirPorId(@PathVariable Integer id, @RequestParam String senha) {
        cartaoService.excluir(id.toString(), senha);
    }
}
