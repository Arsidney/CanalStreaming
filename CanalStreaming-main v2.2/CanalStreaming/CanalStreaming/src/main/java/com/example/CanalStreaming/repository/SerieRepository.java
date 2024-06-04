package com.example.CanalStreaming.repository;

import com.example.CanalStreaming.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    List<Serie> findByTituloAndDescricao(String titulo, String descricao);
    List<Serie> findByTitulo(String titulo);
    List<Serie> findByTituloOrderByTituloAsc(String titulo);
}
