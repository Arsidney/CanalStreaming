package com.example.CanalStreaming.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHandler {

    @ExceptionHandler(EmailJaUsadoException.class)
    public ResponseEntity<String> handleEmailJaUsadoException(EmailJaUsadoException e) {
        return new ResponseEntity<>("error 101: Email já foi usado", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SenhaNaoCombinaException.class)
    public ResponseEntity<String> handleSenhaNaoCombinaException(SenhaNaoCombinaException e) {
        return new ResponseEntity<>("error 102: Senhas incorretas", HttpStatus.BAD_REQUEST);
    }
}
