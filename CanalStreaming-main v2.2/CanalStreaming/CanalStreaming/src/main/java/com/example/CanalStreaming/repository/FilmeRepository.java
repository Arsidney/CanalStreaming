package com.example.CanalStreaming.repository;

import com.example.CanalStreaming.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    List<Filme> findByTituloAndDescricao(String titulo, String descricao);
    List<Filme> findByTitulo(String titulo);
    List<Filme> findByTituloOrderByTituloAsc(String titulo);
}
