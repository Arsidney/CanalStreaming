package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.DTO.UsuarioCartaoDTO;
import com.example.CanalStreaming.Model.*;
import com.example.CanalStreaming.Repository.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {


    private UsuarioRepository usuarioRepository;
    private CartaoCreditoRepository cartaoCreditoRepository;
    private FilmesRepository filmesRepository;
    private SeriesRepository seriesRepository;
    private FavoritosRepository favoritosRepository;

    @Autowired
    private JavaMailSender emailSender;

    public Usuario cadastrarUsuarioComCartao(UsuarioCartaoDTO usuarioCartaoDTO) {
        Usuario usuario = usuarioCartaoDTO.getUsuario();
        CartaoCredito cartaoCredito = usuarioCartaoDTO.getCartaoCredito();

        String confirmationToken = RandomStringUtils.randomAlphanumeric(64);
        usuario.setConfirmationToken(confirmationToken);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        cartaoCredito.setUsuario(usuarioSalvo);
        cartaoCreditoRepository.save(cartaoCredito);

        enviarEmailConfirmacao(usuario.getEmail(), confirmationToken);

        return usuarioSalvo;
    }
    private void enviarEmailConfirmacao(String email, String confirmationToken) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setSubject("Confirmação de Cadastro");
            helper.setText("Para confirmar seu cadastro, clique no seguinte link: http://seusite.com/confirmacao?token=" + confirmationToken);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        emailSender.send(message);
    }
    public boolean confirmarCadastro(String confirmationToken) {
        Usuario usuario = usuarioRepository.findByConfirmationToken(confirmationToken)
                .orElseThrow(() -> new RuntimeException("Token de confirmação inválido ou expirado."));

        // Marcar o usuário como confirmado e limpar o token
        usuario.setConfirmado(true);
        usuario.setConfirmationToken(null);
        usuarioRepository.save(usuario);

        return true;
    }
    public Usuario atualizarUsuario(Integer id, UsuarioCartaoDTO usuarioCartaoDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        CartaoCredito cartaoCredito = cartaoCreditoRepository.findByUsuarioId(id)
                .orElseThrow(() -> new RuntimeException("Cartão de crédito não encontrado"));

        usuario.setNomeCompleto(usuarioCartaoDTO.getUsuario().getNomeCompleto());
        usuario.setDataNascimento(usuarioCartaoDTO.getUsuario().getDataNascimento());
        usuario.setEmail(usuarioCartaoDTO.getUsuario().getEmail());
        usuario.setSenha(usuarioCartaoDTO.getUsuario().getSenha());

        cartaoCredito.setNumeroCartao(usuarioCartaoDTO.getCartaoCredito().getNumeroCartao());
        cartaoCredito.setValidade(usuarioCartaoDTO.getCartaoCredito().getValidade());
        cartaoCredito.setCodSeguranca(usuarioCartaoDTO.getCartaoCredito().getCodSeguranca());
        cartaoCredito.setNomeTitular(usuarioCartaoDTO.getCartaoCredito().getNomeTitular());
        cartaoCredito.setCpf(usuarioCartaoDTO.getCartaoCredito().getCpf());

        usuarioRepository.save(usuario);
        cartaoCreditoRepository.save(cartaoCredito);

        return usuario;
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
    public List<Favoritos> listarFilmesFavoritos(Integer usuarioId) {
        return favoritosRepository.findByUsuarioIdAndFilmeIdIsNotNull(usuarioId);
    }

    public List<Favoritos> listarSeriesFavoritas(Integer usuarioId) {
        return favoritosRepository.findByUsuarioIdAndSerieIdIsNotNull(usuarioId);
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

