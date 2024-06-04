package com.example.CanalStreaming.Config;

import com.example.CanalStreaming.DTO.MovieDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TmdbResponse {

    @JsonProperty("results")
    private List<MovieDTO> results;

    public List<MovieDTO> getResults() {
        return results;
    }

    public void setResults(List<MovieDTO> results) {
        this.results = results;
    }
}
