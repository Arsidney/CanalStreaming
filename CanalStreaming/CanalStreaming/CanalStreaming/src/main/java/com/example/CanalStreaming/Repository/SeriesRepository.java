package com.example.CanalStreaming.Repository;

import com.example.CanalStreaming.Model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {
    Optional<Series> findByTitulo(String titulo);
}
