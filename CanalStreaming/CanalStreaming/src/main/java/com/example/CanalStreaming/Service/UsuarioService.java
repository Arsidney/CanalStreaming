package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.DTO.UsuarioCartaoDTO;
import com.example.CanalStreaming.Model.CartaoCredito;
import com.example.CanalStreaming.Model.Usuario;
import com.example.CanalStreaming.Repository.CartaoCreditoRepository;
import com.example.CanalStreaming.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private CartaoCreditoRepository cartaoCreditoRepository;

    public Usuario cadastrarUsuarioComCartao(UsuarioCartaoDTO usuarioCartaoDTO) {
        Usuario usuario = usuarioCartaoDTO.getUsuario();
        CartaoCredito cartaoCredito = usuarioCartaoDTO.getCartaoCredito();

        Usuario usuarioSalvo = usuarioRepository.save(usuario);


        cartaoCredito.setUsuario(usuarioSalvo);


        cartaoCreditoRepository.save(cartaoCredito);

        return usuarioSalvo;
    }


    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }


    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public void deletarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }



}
