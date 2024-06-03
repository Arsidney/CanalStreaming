package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.Model.Favoritos;
import com.example.CanalStreaming.Repository.FavoritosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FavoritosService {

    private final FavoritosRepository favoritosRepository;

    public Favoritos salvar(Favoritos favoritos) {
        return favoritosRepository.save(favoritos);
    }

    public List<Favoritos> listarFavoritos() {
        return favoritosRepository.findAll();
    }

    public Favoritos buscarPorId(Integer id) {
        return favoritosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorito não encontrado com id " + id));
    }

    public Favoritos atualizar(Favoritos favoritos) {
        if (favoritos.getId() == null) {
            throw new RuntimeException("Favorito sem ID");
        }
        return favoritosRepository.save(favoritos);
    }

    public void deletarPorId(Integer id) {
        favoritosRepository.deleteById(id);
    }

    // Métodos para listar filmes e séries favoritos separadamente
    public List<Favoritos> listarFilmesFavoritos(Integer usuarioId) {
        return favoritosRepository.findByUsuarioIdAndFilmeIdIsNotNull(usuarioId);
    }

    public List<Favoritos> listarSeriesFavoritas(Integer usuarioId) {
        return favoritosRepository.findByUsuarioIdAndSerieIdIsNotNull(usuarioId);
    }
}

