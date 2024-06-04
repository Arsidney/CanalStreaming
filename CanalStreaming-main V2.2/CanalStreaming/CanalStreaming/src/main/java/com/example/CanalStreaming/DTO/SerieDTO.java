package com.example.CanalStreaming.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SerieDTO {
    private String name;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    @JsonProperty("first_air_date")
    private String firstAirDate;

    private Integer runtime;

    private Double popularity;

    private String overview;

    private Integer id;
}
