package com.example.CanalStreaming.controller;

import com.example.CanalStreaming.model.Filme;
import com.example.CanalStreaming.service.FilmeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/filme")
public class FilmeController {

    private FilmeService service;

    @PostMapping("/Adicionar")
    public Filme salvar(@Valid @RequestBody Filme filme){

        return service.salvar(filme);
    }

    @GetMapping("/Lista")
    public List<Filme> listarTodos(){

        return service.listarTodos();
    }

    @PutMapping("/{id}/Atualizar")
    public Filme atualizar(@PathVariable Integer id, @RequestBody Filme filme){
        filme.setId(id);
        return service.atualizar(filme);
    }

    @GetMapping("/{id}/Buscar")
    public Filme buscarPorId(@PathVariable Integer id){

        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}/Deletar")
    public void excluirPorId(@PathVariable Integer id){

        service.excluir(id);
    }
}
