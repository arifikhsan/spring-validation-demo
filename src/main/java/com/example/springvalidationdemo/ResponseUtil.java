package com.example.springvalidationdemo;

import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ResponseUtil {
    public static <T> ResponseEntity<T> unprocessableEntity(T body) {
        return ResponseEntity.unprocessableEntity().body(body);
    }
}
