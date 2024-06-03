package com.example.CanalStreaming.Repository;


import com.example.CanalStreaming.Model.CartaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Integer> {

    Optional<CartaoCredito> findByNumeroCartao(String numeroCartao);
    Optional<CartaoCredito> findByUsuarioId(Integer usuarioId);


}