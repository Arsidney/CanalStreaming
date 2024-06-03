package com.example.CanalStreaming.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String genero;
    private Integer ano;
    private Integer duracao;
    private String relevancia;
    private String sinopse;
    private String trailer;
    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    private List<Favoritos> favoritos;

}