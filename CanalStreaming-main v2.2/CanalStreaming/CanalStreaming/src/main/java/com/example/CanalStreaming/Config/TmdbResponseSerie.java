package com.example.CanalStreaming.Config;

import com.example.CanalStreaming.DTO.SerieDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TmdbResponseSerie {
    @JsonProperty("results")
    private List<SerieDTO> results;
}
