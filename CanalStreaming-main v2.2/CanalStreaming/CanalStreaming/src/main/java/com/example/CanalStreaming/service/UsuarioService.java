package com.example.CanalStreaming.service;

import com.example.CanalStreaming.handler.SenhaIncorretaException;
import com.example.CanalStreaming.handler.UsuarioNaoEncontradoException;
import com.example.CanalStreaming.model.Usuario;
import com.example.CanalStreaming.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {

    public UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {

        return usuarioRepository.findById(id);
    }

    public Usuario atualizarUsuario(Long id, String senha, Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioExistente = optionalUsuario.get();
            if (usuarioExistente.getSenha().equals(senha)) {
                usuario.setId(id);
                return usuarioRepository.save(usuario);
            } else {
                throw new SenhaIncorretaException("Senha incorreta");
            }
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }
    }

    public void excluirUsuario(Long id, String senha) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getSenha().equals(senha)) {
                usuarioRepository.delete(usuario);
            } else {
                throw new SenhaIncorretaException("Senha incorreta");
            }
        } else {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado");
        }
    }

}

