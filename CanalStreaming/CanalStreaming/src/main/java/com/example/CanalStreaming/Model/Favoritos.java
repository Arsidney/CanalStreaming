package com.example.CanalStreaming.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer usuarioId;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filmes filme;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Series serie;
}
