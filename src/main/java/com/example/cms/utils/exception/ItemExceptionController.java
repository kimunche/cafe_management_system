package com.example.cms.utils.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionController {
    @ExceptionHandler(ItemAlreadyExistsException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(ItemAlreadyExistsException e){
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
    }
}
