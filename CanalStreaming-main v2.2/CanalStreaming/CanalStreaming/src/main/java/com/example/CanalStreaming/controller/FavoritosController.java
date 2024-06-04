package com.example.CanalStreaming.controller;

import com.example.CanalStreaming.model.Favoritos;
import com.example.CanalStreaming.service.FavoritosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/favoritos")
public class FavoritosController {
    @Autowired
    private FavoritosService favoritoService;

    @PostMapping("/usuario/{usuarioId}/filme/{filmeId}")
    public Favoritos adicionarFilmeAFavoritos(@PathVariable Long usuarioId, @PathVariable Long filmeId) {
        return favoritoService.adicionarFilmeAFavoritos(usuarioId, filmeId);
    }

    @PostMapping("/usuario/{usuarioId}/serie/{serieId}")
    public Favoritos adicionarSerieAFavoritos(@PathVariable Long usuarioId, @PathVariable Long serieId) {
        return favoritoService.adicionarSerieAFavoritos(usuarioId, serieId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Favoritos> listarTodosFavoritosPorUsuario(@PathVariable Long usuarioId) {
        return favoritoService.listarTodosFavoritosPorUsuario(usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}/filmes")
    public List<Favoritos> listarFilmesFavoritosPorUsuario(@PathVariable Long usuarioId) {
        return favoritoService.listarFilmesFavoritosPorUsuario(usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}/series")
    public List<Favoritos> listarSeriesFavoritosPorUsuario(@PathVariable Long usuarioId) {
        return favoritoService.listarSeriesFavoritosPorUsuario(usuarioId);
    }

    @DeleteMapping("/{favoritoId}")
    public void deletarFavoritoPorId(@PathVariable Integer favoritoId) {
        favoritoService.deletarFavoritoPorId(favoritoId);
    }
}
