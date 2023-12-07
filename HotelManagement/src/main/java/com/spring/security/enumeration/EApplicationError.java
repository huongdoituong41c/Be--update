package com.spring.security.enumeration;

import com.spring.security.dto.ErrorExceptionDto;

public enum EApplicationError implements ErrorObjectInterface{

    ROOM_NOT_FOUND("R01", "Room Not Found");

    private String code;
    private String message;

    EApplicationError(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public ErrorExceptionDto getErrorObject() {
        return new ErrorExceptionDto(this.code, this.message);
    }
}
