package com.example.CanalStreaming.repository;

import com.example.CanalStreaming.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, PagingAndSortingRepository<Usuario, Long> {
    List<Usuario> findAllByOrderByNomeCompletoAsc();
    boolean existsByEmail(String email);
}
