package com.example.springvalidationdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorsValidationResponseDto {
    private String message;
    private List<FieldErrorValidationResponseDto> errors;

    public ErrorsValidationResponseDto(List<FieldErrorValidationResponseDto> errors) {
        this.message = "Validation error";
        this.errors = errors;
    }
}
