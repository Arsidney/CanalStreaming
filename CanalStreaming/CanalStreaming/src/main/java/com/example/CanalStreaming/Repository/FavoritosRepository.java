package com.example.CanalStreaming.Repository;

import com.example.CanalStreaming.Model.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos, Integer> {
    Optional<Favoritos> findByFilmeId(Integer filmeId);
}
