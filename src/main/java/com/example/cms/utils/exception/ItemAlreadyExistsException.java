package com.example.cms.utils.exception;

import lombok.Getter;

@Getter
public class ItemAlreadyExistsException extends RuntimeException{
    ErrorCode errorCode;

    public ItemAlreadyExistsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
