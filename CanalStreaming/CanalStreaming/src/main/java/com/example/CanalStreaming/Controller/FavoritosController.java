package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.Model.Favoritos;
import com.example.CanalStreaming.Service.FavoritosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Favoritos")
public class FavoritosController {

    private final FavoritosService favoritosService;

    @PostMapping
    public Favoritos salvar(@RequestBody Favoritos favoritos) {
        return favoritosService.salvar(favoritos);
    }

    @GetMapping
    public List<Favoritos> listarFavoritos() {
        return favoritosService.listarFavoritos();
    }

    @GetMapping("/titulo")
    public Optional<Favoritos> buscarPorFilmeId(@RequestParam Integer filmeId) {
        return favoritosService.buscarPorFilmeId(filmeId);
    }

    @GetMapping("/{id}")
    public Favoritos buscarPorId(@PathVariable Integer id) {
        return favoritosService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Integer id) {
        favoritosService.deletarPorId(id);
    }
}

