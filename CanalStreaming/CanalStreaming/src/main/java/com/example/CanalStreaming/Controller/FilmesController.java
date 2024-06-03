package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.Model.Filmes;
import com.example.CanalStreaming.Service.FilmesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Filmes")
public class FilmesController {


    private FilmesService filmesService;


    @PostMapping
    public Filmes salvar(@RequestBody Filmes filmes) {
        return filmesService.salvar(filmes);
    }

    @GetMapping
    public List<Filmes> listarFilmes() {
        return filmesService.listarFilmes();
    }

    @GetMapping("/titulo") //por titulo
    public Optional<Filmes> buscarPorTitulo(String titulo) {
        return filmesService.buscarPorTitulo(titulo);
    }

    @GetMapping("/{id}")
    public Filmes buscarPorId(@PathVariable Integer id) {
        return filmesService.buscarPorId(id);
    }


    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Integer id) {
        filmesService.deletarPorId(id);
    }
}
