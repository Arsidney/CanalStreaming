package com.example.CanalStreaming.controller;

import com.example.CanalStreaming.DTO.MovieDTO;
import com.example.CanalStreaming.DTO.SerieDTO;
import com.example.CanalStreaming.model.Favorites;
import com.example.CanalStreaming.service.FavoriteService;
import com.example.CanalStreaming.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final TmdbService tmdbService;
    private final FavoriteService favoriteService;

    @Autowired
    public MovieController(TmdbService tmdbService, FavoriteService favoriteService) {
        this.tmdbService = tmdbService;
        this.favoriteService = favoriteService;
    }

    @GetMapping("/Procurar_Filme")
    public List<MovieDTO> searchMovies(@RequestParam String query) {
        return tmdbService.searchMovies(query);
    }

    @GetMapping("/Procurar_Serie")
    public List<SerieDTO> searchSeries(@RequestParam String query) {
        return tmdbService.searchSeries(query);
    }

    @PostMapping("/Favoritar_Filme")
    public Favorites addFavoriteMovie(@RequestParam int movieId, @RequestParam String name) {
        return favoriteService.addFavoriteMovie(movieId, name);
    }

    @PostMapping("/Favoritar_Serie")
    public Favorites addFavoriteSeries(@RequestParam int serieId, @RequestParam String name) {
        return favoriteService.addFavoriteSeries(serieId, name);
    }

    @GetMapping("/Favoritos")
    public Favorites getFavorites(@RequestParam String name) {
        return favoriteService.getFavorites(name);
    }

    @GetMapping("/Ordenar_Favoritos")
    public Favorites getSortedFavorites(@RequestParam String name) {
        return favoriteService.getSortedFavorites(name);
    }
    @DeleteMapping("/favoritos/{name}/remover_Filme")
    public Favorites removeFavoriteMovie(@PathVariable String name, @RequestParam int movieId) {
        return favoriteService.removeFavoriteMovie(movieId, name);
    }

    @DeleteMapping("/favoritos/{name}/remover_serie")
    public Favorites removeFavoriteSerie(@PathVariable String name, @RequestParam int serieId) {
        return favoriteService.removeFavoriteSerie(serieId, name);
    }
}

