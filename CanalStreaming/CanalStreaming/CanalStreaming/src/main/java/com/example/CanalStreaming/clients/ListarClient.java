package com.example.CanalStreaming.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "listar",
        url = "http://localhost:8080")
public interface ListarClient {

        @GetMapping("/listar")
        public List<String> listarClient();
    }



