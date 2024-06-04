package com.example.CanalStreaming.service;

import com.example.CanalStreaming.model.Favoritos;
import com.example.CanalStreaming.model.Filme;
import com.example.CanalStreaming.model.Serie;
import com.example.CanalStreaming.model.Usuario;
import com.example.CanalStreaming.repository.FavoritosRepository;
import com.example.CanalStreaming.repository.FilmeRepository;
import com.example.CanalStreaming.repository.SerieRepository;
import com.example.CanalStreaming.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritosService {

    private UsuarioRepository usuarioRepository;

    private FilmeRepository filmeRepository;

    private SerieRepository serieRepository;

    private FavoritosRepository favoritosRepository;

    public Favoritos adicionarFilmeAFavoritos(Long usuarioId, Long filmeId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Filme filme = filmeRepository.findById(Math.toIntExact(filmeId))
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        Favoritos favorito = new Favoritos();
        favorito.setUsuario(usuario);
        favorito.setFilme(filme);

        return favoritosRepository.save(favorito);
    }

    public Favoritos adicionarSerieAFavoritos(Long usuarioId, Long serieId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Serie serie = serieRepository.findById(Math.toIntExact(serieId))
                .orElseThrow(() -> new RuntimeException("Série não encontrada"));

        Favoritos favorito = new Favoritos();
        favorito.setUsuario(usuario);
        favorito.setSerie(serie);

        return favoritosRepository.save(favorito);
    }

    public void deletarFavoritoPorId(Integer favoritoId) {
        favoritosRepository.deleteById(Long.valueOf(favoritoId));
    }

    public List<Favoritos> listarTodosFavoritosPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return favoritosRepository.findByUsuario(usuario);
    }

    public List<Favoritos> listarFilmesFavoritosPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return favoritosRepository.findByUsuarioAndFilmeIsNotNull(usuario);
    }

    public List<Favoritos> listarSeriesFavoritosPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return favoritosRepository.findByUsuarioAndSerieIsNotNull(usuario);
    }
}
