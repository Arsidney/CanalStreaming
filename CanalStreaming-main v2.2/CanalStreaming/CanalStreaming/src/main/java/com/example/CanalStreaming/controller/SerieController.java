package com.example.CanalStreaming.controller;

import com.example.CanalStreaming.model.Serie;
import com.example.CanalStreaming.service.SerieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/serie")
public class SerieController {

    private SerieService service;

    @PostMapping("/Adicionar")
    public Serie salvar(@Valid @RequestBody Serie serie){

        return service.salvar(serie);
    }

    @GetMapping("/lista")
    public List<Serie> listarTodos(){

        return service.listarTodos();
    }

    @PutMapping("/{id}/Atualizar")
    public Serie atualizar(@PathVariable Integer id, @RequestBody Serie serie){
        serie.setId(id);
        return service.atualizar(serie);
    }

    @GetMapping("/{id}/Buscar")
    public Serie buscarPorId(@PathVariable Integer id){

        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}/Deletar")
    public void excluirPorId(@PathVariable Integer id){

        service.excluir(id);
    }
}
