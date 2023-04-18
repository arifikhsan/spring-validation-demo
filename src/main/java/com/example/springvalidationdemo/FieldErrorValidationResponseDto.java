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
public class FieldErrorValidationResponseDto {
    private String field;
    private List<String> errors;
}
