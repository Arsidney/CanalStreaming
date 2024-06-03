package com.example.CanalStreaming.DTO;

import com.example.CanalStreaming.Model.CartaoCredito;
import com.example.CanalStreaming.Model.Usuario;
import lombok.Data;

@Data
public class UsuarioCartaoDTO {

    private Usuario usuario;
    private CartaoCredito cartaoCredito;
}

