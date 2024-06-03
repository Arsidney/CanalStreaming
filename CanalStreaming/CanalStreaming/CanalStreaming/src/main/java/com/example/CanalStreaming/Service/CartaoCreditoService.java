package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.Model.CartaoCredito;
import com.example.CanalStreaming.Model.Usuario;
import com.example.CanalStreaming.Repository.CartaoCreditoRepository;
import com.example.CanalStreaming.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartaoCreditoService {

    private final UsuarioRepository usuarioRepository;
    private final CartaoCreditoRepository cartaoCreditoRepository;
    private final ModelMapper modelMapper;

    public CartaoCredito cadastrar(Integer usuarioId, CartaoCredito cartaoCredito) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        cartaoCredito.setUsuario(usuario);
        return cartaoCreditoRepository.save(cartaoCredito);
    }

    public CartaoCredito atualizarPorUsuarioId(Integer usuarioId, CartaoCredito cartaoCredito) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        CartaoCredito existingCartao = cartaoCreditoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Cartão de crédito não encontrado para o usuário especificado."));

        modelMapper.map(cartaoCredito, existingCartao);
        existingCartao.setUsuario(usuario);
        return cartaoCreditoRepository.save(existingCartao);
    }

    public List<CartaoCredito> listarTodos() {
        return cartaoCreditoRepository.findAll();
    }

    public CartaoCredito buscarCartaoPorNumero(String numeroCartao) {
        return cartaoCreditoRepository.findByNumeroCartao(numeroCartao)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
    }

    public CartaoCredito buscarCartaoPorUsuarioId(Integer usuarioId) {
        return cartaoCreditoRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Cartão de crédito não encontrado para o usuário especificado."));
    }

    public void deletarCartao(Integer id) {
        cartaoCreditoRepository.deleteById(id);
    }
}
