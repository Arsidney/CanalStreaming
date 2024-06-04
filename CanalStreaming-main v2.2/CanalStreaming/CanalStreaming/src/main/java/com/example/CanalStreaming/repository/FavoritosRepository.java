package com.example.CanalStreaming.repository;

import com.example.CanalStreaming.model.Favoritos;
import com.example.CanalStreaming.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
    List<Favoritos> findByUsuario(Usuario usuario);
    List<Favoritos> findByUsuarioAndFilmeIsNotNull(Usuario usuario);
    List<Favoritos> findByUsuarioAndSerieIsNotNull(Usuario usuario);
}
