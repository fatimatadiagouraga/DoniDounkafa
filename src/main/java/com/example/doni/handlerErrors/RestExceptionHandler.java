package com.example.doni.handlerErrors;

import com.example.doni.exception.EntityNotFoundException;
import com.example.doni.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handlerException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final Error error = Error.builder()
                .errorCode(exception.getErrorCode())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
        return new  ResponseEntity<>(error, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<Error> handlerException(InvalidEntityException exception, WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        final Error error = Error.builder()
                .errorCode(exception.getErrorCode())
                .httpCode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new  ResponseEntity<>(error, badRequest);
    }
}
