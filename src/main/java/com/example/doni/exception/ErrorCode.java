package com.example.doni.exception;

public enum ErrorCode {
    PAYSANS_NOT_FOUND(1000),
    PAYSANS_NOT_VALID(1001),
    PAYSANS_ALREADY_EXISTE(1002),
    PAYSANS_AUTHENTIFICATION_INVALID(1003),
    PAYSANS_DESACTIVE_ACCOUNT(1004),

    ;

    private int code;
    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
