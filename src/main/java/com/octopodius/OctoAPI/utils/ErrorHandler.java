package com.octopodius.OctoAPI.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handlerNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handlerSQLExceptionsBadRequest(SQLException ex) {
        String message = "Internal Exception Error";
        String field = "Not Determined";
        List<ErrorHandlerDTO> errList = new LinkedList<ErrorHandlerDTO>();

        boolean isDuplicateKey = ex.getMessage().toLowerCase().contains("duplicate") && ex.getMessage().toLowerCase().contains("key");

        if (isDuplicateKey) {
            message = "duplicate";
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(ex.getMessage());

            if (matcher.find()) {
                String duplicateKey = matcher.group(1);
                field = duplicateKey;
            }
        }

        errList.add(new ErrorHandlerDTO(field, message));
        return ResponseEntity.badRequest().body(errList);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodsArgumentNotValidBadRequest(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body( errors.stream().map(ErrorHandlerDTO::new).toList() );
    }


    private record ErrorHandlerDTO(String field, String cause) {
        public ErrorHandlerDTO(FieldError errors) {
            this(errors.getField(), errors.getDefaultMessage());
        }
    }

}
