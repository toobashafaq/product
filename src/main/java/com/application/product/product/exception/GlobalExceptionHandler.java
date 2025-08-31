package com.application.product.product.exception;

import com.application.product.product.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException e, WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                webRequest.getDescription(false),HttpStatus.CONFLICT,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFound(CategoryNotFoundException e,WebRequest webRequest){
            ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                    webRequest.getDescription(false),HttpStatus.NOT_FOUND,
                    e.getMessage(),
                    LocalDateTime.now()
            );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleCategoryNotFound(Exception e,WebRequest webRequest){
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
    }
}
