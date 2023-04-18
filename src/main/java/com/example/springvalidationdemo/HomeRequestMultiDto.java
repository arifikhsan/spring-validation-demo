package com.example.springvalidationdemo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeRequestMultiDto {
    @NotBlank
    @Size(min = 5)
    @NameConstraint
    private String name;
    @Min(10)
    private int age;
    private MultipartFile file;
}
