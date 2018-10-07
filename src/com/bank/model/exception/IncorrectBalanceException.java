package com.bank.model.exception;

public class IncorrectBalanceException extends RuntimeException {

    @Override
    public String getMessage() {
        return "The balance is too low";
    }
}
