package com.example.CanalStreaming.model;

import com.example.CanalStreaming.DTO.MovieDTO;
import com.example.CanalStreaming.DTO.SerieDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Favorites {
    private List<MovieDTO> favoriteMovies;
    private List<SerieDTO> favoriteSeries;

    public Favorites() {
        this.favoriteMovies = new ArrayList<>();
        this.favoriteSeries = new ArrayList<>();
    }

    public List<MovieDTO> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(List<MovieDTO> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public List<SerieDTO> getFavoriteSeries() {
        return favoriteSeries;
    }

    public void setFavoriteSeries(List<SerieDTO> favoriteSeries) {
        this.favoriteSeries = favoriteSeries;
    }
}
