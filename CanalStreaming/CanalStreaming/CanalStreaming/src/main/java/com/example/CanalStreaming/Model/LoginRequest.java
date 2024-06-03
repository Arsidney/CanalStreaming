package com.example.CanalStreaming.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String cpf;
    private String senha;
}