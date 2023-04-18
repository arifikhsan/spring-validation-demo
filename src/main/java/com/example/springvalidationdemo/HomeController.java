package com.example.springvalidationdemo;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Validated
@RestController
public class HomeController {
    @PostMapping(consumes = {MULTIPART_FORM_DATA_VALUE})
    @RequestMapping("/")
//    public Map<String, String> getHome(@Valid @RequestBody HomeRequestDto dto) {
    public Map<String, String> getHome(
            @Valid @ModelAttribute HomeRequestMultiDto dto,
            BindingResult bindingResult) {
            return Map.of("name", dto.getName());
        }
    }
