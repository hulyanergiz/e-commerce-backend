package com.workintech.ecommerce.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleEcommerceException(EcommerceException exception){
    ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(), Instant.now());
    log.error("E-commerce exception:"+errorResponse.getMessage());
    return new ResponseEntity<>(errorResponse,exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handle(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String, String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(), Instant.now());
        log.error("Exception:"+errorResponse.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
