package com.example.CanalStreaming.clients;

import com.example.CanalStreaming.Model.Filmes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "filmeslib", url = "https://api.themoviedb.org/3/movie/550?api_key=b540e0aceabecd67ae191fe55f09d6cc")
public interface APIClient {

    @GetMapping("/{query}/json")
    public Filmes consultaEndereco(@PathVariable String query);
}
