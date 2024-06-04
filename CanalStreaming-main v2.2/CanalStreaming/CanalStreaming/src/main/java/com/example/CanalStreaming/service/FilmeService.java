package com.example.CanalStreaming.service;

import com.example.CanalStreaming.model.Filme;
import com.example.CanalStreaming.repository.FilmeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FilmeService {

    @PersistenceContext
    private EntityManager entityManager;

    private FilmeRepository repository;

    public Filme salvar(Filme filme){

        return repository.save(filme);
    }

    public List<Filme> listarTodos(){

        return repository.findAll();
    }

    public Filme atualizar(Filme filme){
        if(filme.getId() == null){
            throw new RuntimeException("Filme sem ID");
        }
        return repository.save(filme);
    }

    public Filme buscarPorId(Integer id) {
        return
                repository.findById(id).orElse(null);
    }

    @Transactional
    public void excluir(Integer id){

        repository.deleteById(id);
    }


}
