package com.example.CanalStreaming.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nomeTitular;

    @NotBlank
    @Size(min = 11)
    private String cpf;

    @Size(min = 14, message = "O CNPJ deve ter pelo menos 14 caracteres")
    private String cnpj;

    @NotBlank
    @Size(min = 16)
    private String numeroCartao;

    @NotNull
    @Min(3)
    private Integer codSeguranca;

    @NotNull
    private LocalDate validade;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
