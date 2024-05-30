package com.example.CanalStreaming.Repository;

import com.example.CanalStreaming.Model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Integer> {
    Optional<Filmes> findByTitulo(String titulo);

}
