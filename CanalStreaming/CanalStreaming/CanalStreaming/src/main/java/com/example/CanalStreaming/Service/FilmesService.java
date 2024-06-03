package com.example.CanalStreaming.Service;

import com.example.CanalStreaming.Model.Filmes;
import com.example.CanalStreaming.Repository.FilmesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FilmesService {

    private FilmesRepository filmesRepository;

    public Filmes salvar(Filmes filmes) {
        return filmesRepository.save(filmes);
    }


    public List<Filmes>listarFilmes() {
        return filmesRepository.findAll();
    }

    public List<Filmes> listarFilmesOrdemAlfabetica() {
        return filmesRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
    }

    public Filmes buscarPorId(Integer id) {
        return filmesRepository.findById(id).get();
    }


    public Optional<Filmes> buscarPorTitulo(String titulo) {
        return filmesRepository.findByTitulo(titulo);
    }


    public Filmes atualizar(Filmes filme) {
        if (filme.getId() == null) {
            throw new RuntimeException("Filme sem ID");
        }
        return filmesRepository.save(filme);
    }


    public void deletarPorId(Integer id){
        filmesRepository.deleteById(id);
    }
}

