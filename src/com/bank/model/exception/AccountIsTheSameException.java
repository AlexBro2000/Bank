package com.bank.model.exception;

public class AccountIsTheSameException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Account is the same";
    }
}
