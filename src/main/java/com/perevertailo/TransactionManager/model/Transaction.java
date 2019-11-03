package com.perevertailo.TransactionManager.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {

    String id;
    TransactionType type;
    double amount;
    LocalDateTime effectiveDate;

    public Transaction(String id, TransactionType type, double amount, LocalDateTime effectiveDate) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.effectiveDate = effectiveDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setTransactionType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return getType() == that.getType() &&
                getAmount() == (that.getAmount()) &&
                getEffectiveDate().equals(that.getEffectiveDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getAmount(), getEffectiveDate());
    }
}
