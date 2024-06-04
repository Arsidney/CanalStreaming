package com.example.CanalStreaming.service;

import com.example.CanalStreaming.model.Serie;
import com.example.CanalStreaming.repository.SerieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SerieService {

    private SerieRepository repository;

    public Serie salvar(Serie serie){

        return repository.save(serie);
    }

    public List<Serie> listarTodos(){

        return repository.findAll();
    }

    public Serie atualizar(Serie serie){
        if(serie.getId() == null){
            throw new RuntimeException("Serie sem ID");
        }
        return repository.save(serie);
    }

    public Serie buscarPorId(Integer id) {

        return repository.findById(id).orElse(null);
    }

    public void excluir(Integer id){

        repository.deleteById(id);
    }
}
