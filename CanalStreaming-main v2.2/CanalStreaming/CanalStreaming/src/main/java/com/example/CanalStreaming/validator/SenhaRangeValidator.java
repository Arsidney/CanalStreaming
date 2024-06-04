package com.example.CanalStreaming.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhaRangeValidator implements ConstraintValidator<SenhaRange, String> {

    private int min;
    private int max;

    @Override
    public void initialize(SenhaRange constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String senha, ConstraintValidatorContext constraintValidatorContext) {
        return senha != null && senha.length() >= min && senha.length() <= max;
    }
}

