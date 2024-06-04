package com.example.CanalStreaming.service;

import com.example.CanalStreaming.DTO.MovieDTO;
import com.example.CanalStreaming.DTO.SerieDTO;
import com.example.CanalStreaming.model.Favorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    // Armazenamento em memória para os favoritos (substitua por um banco de dados se necessário)
    private final Map<String, Favorites> favoritesMap = new HashMap<>();
    private final TmdbService tmdbService;

    @Autowired
    public FavoriteService(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    public Favorites addFavoriteMovie(int movieId, String name) {
        MovieDTO movieDTO = tmdbService.getMovieById(movieId);
        Favorites favorites = getFavoritesFromMap(name);
        if (favorites == null) {
            favorites = new Favorites();
            favoritesMap.put(name, favorites);
        }
        favorites.getFavoriteMovies().add(movieDTO);
        return favorites;
    }

    public Favorites addFavoriteSeries(int serieId, String name) {
        SerieDTO serieDTO = tmdbService.getSerieById(serieId);
        Favorites favorites = getFavoritesFromMap(name);
        if (favorites == null) {
            favorites = new Favorites();
            favoritesMap.put(name, favorites);
        }
        favorites.getFavoriteSeries().add(serieDTO);
        return favorites;
    }

    public Favorites getFavorites(String name) {
        return favoritesMap.get(name);
    }

    public Favorites getSortedFavorites(String name) {
        Favorites favorites = getFavorites(name);
        if (favorites != null) {
            List<MovieDTO> sortedMovies = favorites.getFavoriteMovies().stream()
                    .sorted((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()))
                    .collect(Collectors.toList());
            List<SerieDTO> sortedSeries = favorites.getFavoriteSeries().stream()
                    .sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                    .collect(Collectors.toList());
            favorites.setFavoriteMovies(sortedMovies);
            favorites.setFavoriteSeries(sortedSeries);
        }
        return favorites;
    }

    private Favorites getFavoritesFromMap(String name) {
        return favoritesMap.get(name);
    }
    public Favorites removeFavoriteMovie(int movieId, String name) {
        Favorites favorites = favoritesMap.getOrDefault(name, new Favorites());
        List<MovieDTO> movies = favorites.getFavoriteMovies();
        movies.removeIf(movie -> movie.getId() == movieId);
        favoritesMap.put(name, favorites);
        return favorites;
    }

    public Favorites removeFavoriteSerie(int serieId, String name) {
        Favorites favorites = favoritesMap.getOrDefault(name, new Favorites());
        List<SerieDTO> series = favorites.getFavoriteSeries();
        series.removeIf(serie -> serie.getId() == serieId);
        favoritesMap.put(name, favorites);
        return favorites;
    }
}