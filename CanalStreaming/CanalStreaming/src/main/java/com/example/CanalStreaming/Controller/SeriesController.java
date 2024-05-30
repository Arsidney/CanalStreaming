package com.example.CanalStreaming.Controller;

import com.example.CanalStreaming.Model.Series;
import com.example.CanalStreaming.Service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/Series")
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @PostMapping
    public Series salvar(@RequestBody Series series) {
        return seriesService.salvar(series);
    }

    @GetMapping
    public List<Series> listarSeries() {
        return seriesService.listarSeries();
    }

    @GetMapping("/titulo") // por titulo
    public Optional<Series> buscarPorTitulo(@RequestParam String titulo) {
        return seriesService.buscarPorTitulo(titulo);
    }

    @GetMapping("/{id}")
    public Series buscarPorId(@PathVariable Integer id) {
        return seriesService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Integer id) {
        seriesService.deletarPorId(id);
    }
}
