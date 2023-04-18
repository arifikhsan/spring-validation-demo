package com.example.springvalidationdemo;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

@Slf4j
@ControllerAdvice
@RestController
public class ExceptionController {
    /**
     * Constraint violation exception handler
     *
     * @param ex ConstraintViolationException
     * @return List<ValidationError> - list of ValidationError built
     * from set of ConstraintViolation
     */
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public Object handleConstraintViolation(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

        var errorMap = new HashMap<String, ArrayList<String>>();

        for (ConstraintViolation<?> violation : violations) {
            var key = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
            var error = violation.getMessage();

            if (errorMap.containsKey(key)) {
                errorMap.get(key).add(error);
            } else {
                errorMap.put(key, new ArrayList<>(Collections.singleton(error)));
            }
        }

        var dto = errorMap.entrySet()
                .stream()
                .map(error -> new FieldErrorValidationResponseDto(error.getKey(), error.getValue()))
                .toList();

        return new ErrorsValidationResponseDto(dto);
    }
}