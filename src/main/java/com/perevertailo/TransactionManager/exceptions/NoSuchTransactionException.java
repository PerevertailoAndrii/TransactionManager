package com.perevertailo.TransactionManager.exceptions;

public class NoSuchTransactionException extends RuntimeException {
    @Override
    public String getMessage() {
        return "There is no transaction with such identifier";
    }
}

