package com.example.CanalStreaming.controller;

import com.example.CanalStreaming.handler.EmailJaUsadoException;
import com.example.CanalStreaming.handler.SenhaNaoCombinaException;
import com.example.CanalStreaming.model.Usuario;
import com.example.CanalStreaming.repository.UsuarioRepository;
import com.example.CanalStreaming.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private UsuarioService usuarioService;

    private final UsuarioRepository usuarioRepository;


    @PostMapping("/Cadastrar")
    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailJaUsadoException("Email já foi usado");
        }

        if (!usuario.getSenha().equals(usuario.getConfirmarSenha())) {
            throw new SenhaNaoCombinaException("Senhas incorretas");
        }

        return usuarioRepository.save(usuario);
    }


    @GetMapping("/Lista") // Listar todos usuarios
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return usuarioService.listarUsuarios();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestParam String senha, @RequestBody Usuario usuario) {
        try {
            Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, senha, usuario);
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}/deletar")
    public void excluirUsuario(@PathVariable Long id, @RequestParam String senha) {
        usuarioService.excluirUsuario(id, senha);
    }


}

