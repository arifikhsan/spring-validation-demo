package com.example.springvalidationdemo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class HomeRequestDto {
    @NotBlank
    @Size(min = 4)
    private String name;

    @Min(3)
    private int age;
}
