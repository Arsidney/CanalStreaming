package com.example.CanalStreaming.Controller;


import com.example.CanalStreaming.Model.CartaoCredito;
import com.example.CanalStreaming.Service.CartaoCreditoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Cartao")
public class CartaoCreditoController {

    private final CartaoCreditoService cartaoCreditoService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<CartaoCredito> adicionarCartao(
            @PathVariable Integer usuarioId,
            @RequestBody CartaoCredito cartaoCredito) {

        CartaoCredito novoCartao = cartaoCreditoService.cadastrar(usuarioId, cartaoCredito);
        return ResponseEntity.ok(novoCartao);
    }

    @PutMapping("/usuario/{usuarioId}")
    public ResponseEntity<CartaoCredito> atualizarPorUsuarioId(
            @PathVariable Integer usuarioId,
            @RequestBody CartaoCredito cartaoCredito) {

        CartaoCredito atualizadoCartao = cartaoCreditoService.atualizarPorUsuarioId(usuarioId, cartaoCredito);
        return ResponseEntity.ok(atualizadoCartao);
    }

    @GetMapping
    public List<CartaoCredito> listarTodos() {
        return cartaoCreditoService.listarTodos();
    }

    @GetMapping("/numero/{numeroCartao}")
    public ResponseEntity<CartaoCredito> buscarPorNumeroCartao(@PathVariable String numeroCartao) {
        CartaoCredito cartaoCredito = cartaoCreditoService.buscarCartaoPorNumero(numeroCartao);
        return ResponseEntity.ok(cartaoCredito);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CartaoCredito> buscarPorUsuarioId(@PathVariable Integer usuarioId) {
        CartaoCredito cartaoCredito = cartaoCreditoService.buscarCartaoPorUsuarioId(usuarioId);
        return ResponseEntity.ok(cartaoCredito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCartao(@PathVariable Integer id) {
        cartaoCreditoService.deletarCartao(id);
        return ResponseEntity.noContent().build();
    }
}