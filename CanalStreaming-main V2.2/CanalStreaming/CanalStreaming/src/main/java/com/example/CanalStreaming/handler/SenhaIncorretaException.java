package com.example.CanalStreaming.handler;

public class SenhaIncorretaException extends RuntimeException {
    public SenhaIncorretaException(String message) {
        super(message);
    }
}
