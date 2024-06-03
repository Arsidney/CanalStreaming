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

    @GetMapping("/alfabetica")
    public List<Filmes> listarFilmesOrdemAlfabetica() {
        return filmesService.listarFilmesOrdemAlfabetica();
    }

    @GetMapping("/titulo")
    public Optional<Filmes> buscarPorTitulo(@RequestParam String titulo) {
        return filmesService.buscarPorTitulo(titulo);
    }

    @GetMapping("/{id}")
    public Filmes buscarPorId(@PathVariable Integer id) {
        return filmesService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Filmes atualizar(@PathVariable Integer id, @RequestBody Filmes filme) {
        filme.setId(id);  // Ensure the ID is set on the filme object
        return filmesService.atualizar(filme);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Integer id) {
        filmesService.deletarPorId(id);
    }
}

