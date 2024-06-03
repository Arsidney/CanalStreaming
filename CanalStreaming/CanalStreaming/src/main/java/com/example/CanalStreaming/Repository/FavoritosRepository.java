package com.example.CanalStreaming.Repository;

import com.example.CanalStreaming.Model.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos, Integer> {
    Optional<Favoritos> findByUsuarioIdAndFilmeId(Integer usuarioId, Integer filmeId);
    Optional<Favoritos> findByUsuarioIdAndSerieId(Integer usuarioId, Integer serieId);
    List<Favoritos> findByUsuarioId(Integer usuarioId);
}