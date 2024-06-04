package com.example.CanalStreaming.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    private String descricao;
    private String genero;
    private String duracao;
    private String trailer;


    @Transient
    private Integer anoLancamento;
}
