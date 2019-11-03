package com.perevertailo.TransactionManager.service;

import com.perevertailo.TransactionManager.model.Transaction;
import com.perevertailo.TransactionManager.model.TransactionBody;

import java.util.List;

public interface TransactionService {

    Transaction getById(String id);
    List<Transaction> getAll();
    void add(TransactionBody transactionBody);
    String getBalance();

}