package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.DTO.UsuarioCartaoDTO;
import com.example.CanalStreaming.Model.*;
import com.example.CanalStreaming.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private CartaoCreditoRepository cartaoCreditoRepository;
    private FilmesRepository filmesRepository; // Adicione isso
    private SeriesRepository seriesRepository; // Adicione isso
    private FavoritosRepository favoritosRepository; // Adicione isso

    public Usuario cadastrarUsuarioComCartao(UsuarioCartaoDTO usuarioCartaoDTO) {
        Usuario usuario = usuarioCartaoDTO.getUsuario();
        CartaoCredito cartaoCredito = usuarioCartaoDTO.getCartaoCredito();

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        cartaoCredito.setUsuario(usuarioSalvo);
        cartaoCreditoRepository.save(cartaoCredito);

        return usuarioSalvo;
    }

    public Favoritos adicionarFilmeFavorito(Integer usuarioId, Integer filmeId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Filmes filme = filmesRepository.findById(filmeId)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        Favoritos favoritos = new Favoritos();
        favoritos.setUsuarioId(usuarioId);
        favoritos.setFilme(filme);

        return favoritosRepository.save(favoritos);
    }
    public void removerFilmeFavorito(Integer usuarioId, Integer filmeId) {
        Favoritos favoritos = favoritosRepository.findByUsuarioIdAndFilmeId(usuarioId, filmeId)
                .orElseThrow(() -> new RuntimeException("Filme favorito não encontrado"));

        favoritosRepository.delete(favoritos);
    }

    public Favoritos adicionarSerieFavorita(Integer usuarioId, Integer serieId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Series serie = seriesRepository.findById(serieId)
                .orElseThrow(() -> new RuntimeException("Série não encontrada"));

        Favoritos favoritos = new Favoritos();
        favoritos.setUsuarioId(usuarioId);
        favoritos.setSerie(serie);

        return favoritosRepository.save(favoritos);
    }
    public void removerSerieFavorita(Integer usuarioId, Integer serieId) {
        Favoritos favoritos = favoritosRepository.findByUsuarioIdAndSerieId(usuarioId, serieId)
                .orElseThrow(() -> new RuntimeException("Série favorita não encontrada"));

        favoritosRepository.delete(favoritos);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
    public List<Favoritos> listarFavoritos(Integer usuarioId) {
        return favoritosRepository.findByUsuarioId(usuarioId);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

