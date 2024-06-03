package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.Model.Favoritos;
import com.example.CanalStreaming.Repository.FavoritosRepository;
import com.example.CanalStreaming.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/favoritos")
public class FavoritosController {

    private final UsuarioService usuarioService;
    private final FavoritosRepository favoritosRepository;

    @PostMapping("/filme/{usuarioId}/{filmeId}")
    public Favoritos adicionarFilmeFavorito(@PathVariable Integer usuarioId, @PathVariable Integer filmeId) {
        return usuarioService.adicionarFilmeFavorito(usuarioId, filmeId);
    }

    @PostMapping("/serie/{usuarioId}/{serieId}")
    public Favoritos adicionarSerieFavorita(@PathVariable Integer usuarioId, @PathVariable Integer serieId) {
        return usuarioService.adicionarSerieFavorita(usuarioId, serieId);
    }

    @DeleteMapping("/filme/{usuarioId}/{filmeId}")
    public ResponseEntity<Void> removerFilmeFavorito(@PathVariable Integer usuarioId, @PathVariable Integer filmeId) {
        usuarioService.removerFilmeFavorito(usuarioId, filmeId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/serie/{usuarioId}/{serieId}")
    public ResponseEntity<Void> removerSerieFavorita(@PathVariable Integer usuarioId, @PathVariable Integer serieId) {
        usuarioService.removerSerieFavorita(usuarioId, serieId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{usuarioId}")
    public List<Favoritos> listarFavoritos(@PathVariable Integer usuarioId) {
        return usuarioService.listarFavoritos(usuarioId);
    }
}
