package com.perevertailo.TransactionManager.exceptions;

public class OutOfBalanceException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Credit amount is greater than balance";
    }
}
