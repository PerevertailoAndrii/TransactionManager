package com.perevertailo.TransactionManager.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class TransactionBody {

    TransactionType type;
    double amount;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


    @Min(value = 0, message = "Amount should be greater than 0")
    @Max(value = Long.MAX_VALUE, message = "Amount is to big")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}