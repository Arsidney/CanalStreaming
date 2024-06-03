package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.Model.Series;
import com.example.CanalStreaming.Repository.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SeriesService {

    private SeriesRepository seriesRepository;

    public Series salvar(Series series) {
        return seriesRepository.save(series);
    }

    public List<Series> listarSeries() {
        return seriesRepository.findAll();
    }

    public Series buscarPorId(Integer id) {
        return seriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Série não encontrada"));
    }

    public Optional<Series> buscarPorTitulo(String titulo) {
        return seriesRepository.findByTitulo(titulo);
    }

    public Series atualizar(Series series) {
        if (series.getId() == null) {
            throw new RuntimeException("Série sem ID");
        }
        return seriesRepository.save(series);
    }

    public void deletarPorId(Integer id) {
        seriesRepository.deleteById(id);
    }
}
