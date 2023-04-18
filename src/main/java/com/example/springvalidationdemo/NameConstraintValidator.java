package com.example.springvalidationdemo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class NameConstraintValidator implements ConstraintValidator<NameConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("ccccccc");
        return Objects.equals(value, "budi");
    }
}
