package com.example.CanalStreaming.model;

import com.example.CanalStreaming.validator.SenhaRange;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private LocalDate dataNascimento;

    private String email;

    @SenhaRange(min = 4, max = 14, message = "A senha deve ter entre 4 e 14 caracteres.")
    private String senha;

    @Transient
    private String confirmarSenha;

    private String cpfCnpj;
}

