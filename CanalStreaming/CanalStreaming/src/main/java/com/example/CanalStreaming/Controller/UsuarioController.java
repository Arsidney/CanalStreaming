package com.example.CanalStreaming.Controller;


import com.example.CanalStreaming.DTO.UsuarioCartaoDTO;
import com.example.CanalStreaming.Model.Usuario;
import com.example.CanalStreaming.Service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    private UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioCartaoDTO usuarioCartaoDTO) {
        Usuario novoUsuario = usuarioService.cadastrarUsuarioComCartao(usuarioCartaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioCartaoDTO usuarioCartaoDTO) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioCartaoDTO);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Integer id){
        usuarioService.deletarPorId(id);
    }
}
