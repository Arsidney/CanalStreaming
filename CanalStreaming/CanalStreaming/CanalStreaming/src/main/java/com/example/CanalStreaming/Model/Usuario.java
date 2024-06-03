package com.example.CanalStreaming.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    @Size(min = 6)
    private String senha;

    @Column(name = "confirmacao_token")
    private String confirmationToken;

    private boolean confirmado;

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }


}