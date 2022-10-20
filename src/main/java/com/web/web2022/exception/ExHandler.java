package com.web.web2022.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExHandler {
    @ExceptionHandler({ConstraintViolationException.class, NoSuchElementException.class})
    public ResponseEntity<Object> ex() {
        return ResponseEntity.badRequest().build();
    }

}
