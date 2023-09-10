package com.co.nexos.mercancia.config;

import com.co.nexos.mercancia.config.exceptions.BadRequestException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionConfig extends RuntimeException{
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler({BadRequestException.class, DataIntegrityViolationException.class, ConstraintViolationException.class})
    public ResponseEntity<?> badRequestException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
