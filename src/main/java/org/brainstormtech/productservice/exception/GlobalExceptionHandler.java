package org.brainstormtech.productservice.exception;

import org.brainstormtech.productservice.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder()
      .message(ex.getMessage())
      .errorCode(HttpStatus.NOT_FOUND.value())
      .build();
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

}