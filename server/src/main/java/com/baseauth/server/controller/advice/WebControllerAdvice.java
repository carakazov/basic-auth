package com.baseauth.server.controller.advice;

import com.baseauth.server.execption.AuthenticationException;
import com.baseauth.server.execption.LoginAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WebControllerAdvice {
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LoginAlreadyExistsException.class)
    public ResponseEntity<String> handleLoginAlreadyExistsException(LoginAlreadyExistsException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>("Login already exists", HttpStatus.CONFLICT);
    }
}
