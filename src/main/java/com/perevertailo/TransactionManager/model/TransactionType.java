package com.perevertailo.TransactionManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransactionType {
    @JsonProperty("debit")
    DEBIT,
    @JsonProperty("credit")
    CREDIT
}