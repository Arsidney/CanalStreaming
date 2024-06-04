package com.example.CanalStreaming.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieDTO {
    private String title;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds; // Mudança de Integer para String

    @JsonProperty("release_date")
    private String releaseDate;

    private Integer runtime;

    private Double popularity;

    private String overview;

    private Boolean video;

    private Integer id;
}
