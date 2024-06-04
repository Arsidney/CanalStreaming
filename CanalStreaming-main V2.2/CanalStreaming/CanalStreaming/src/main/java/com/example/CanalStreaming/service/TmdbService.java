package com.example.CanalStreaming.service;

import com.example.CanalStreaming.Config.TmdbResponse;
import com.example.CanalStreaming.Config.TmdbResponseSerie;
import com.example.CanalStreaming.DTO.MovieDTO;
import com.example.CanalStreaming.DTO.SerieDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String tmdbApiKey;

    private final String TMDB_API_URL = "https://api.themoviedb.org/3/search/movie";
    private final String TMDB_API_URL_SERIES = "https://api.themoviedb.org/3/search/tv";

    private final RestTemplate restTemplate;

    public TmdbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MovieDTO> searchMovies(String query) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TMDB_API_URL)
                .queryParam("api_key", tmdbApiKey)
                .queryParam("query", query);

        TmdbResponse response = restTemplate.getForObject(builder.toUriString(), TmdbResponse.class);
        return response.getResults();
    }

    public List<SerieDTO> searchSeries(String query) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TMDB_API_URL_SERIES)
                .queryParam("api_key", tmdbApiKey)
                .queryParam("query", query);

        TmdbResponseSerie response = restTemplate.getForObject(builder.toUriString(), TmdbResponseSerie.class);
        return response.getResults();
    }


    public MovieDTO getMovieById(int movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + tmdbApiKey;
        return restTemplate.getForObject(url, MovieDTO.class);
    }

    public SerieDTO getSerieById(int serieId) {
        String url = "https://api.themoviedb.org/3/tv/" + serieId + "?api_key=" + tmdbApiKey;
        return restTemplate.getForObject(url, SerieDTO.class);
    }
}
