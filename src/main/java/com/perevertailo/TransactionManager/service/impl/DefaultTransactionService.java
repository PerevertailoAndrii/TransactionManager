package com.perevertailo.TransactionManager.service.impl;

import com.perevertailo.TransactionManager.exceptions.NoSuchTransactionException;
import com.perevertailo.TransactionManager.exceptions.OutOfBalanceException;
import com.perevertailo.TransactionManager.model.Transaction;
import com.perevertailo.TransactionManager.model.TransactionBody;
import com.perevertailo.TransactionManager.model.TransactionType;
import com.perevertailo.TransactionManager.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class DefaultTransactionService implements TransactionService {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();
    private final List<Transaction> transactions = new ArrayList<>();
    private double balance = 0.0;

    @Override
    public Transaction getById(String id) {
        try {
            readLock.lock();
            return transactions.stream().filter(transaction -> transaction.getId().equals(id)).findFirst().orElseThrow(NoSuchTransactionException::new);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public String getBalance() {
        try {
            readLock.lock();
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.DOWN);
            return df.format(balance);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public List<Transaction> getAll() {
        try {
            readLock.lock();
            return transactions;
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void add(TransactionBody transactionBody) {
        try {
            writeLock.lock();
            if (transactionBody.getType().equals(TransactionType.DEBIT)) {
                balance += transactionBody.getAmount();
            } else {
                if (balance < transactionBody.getAmount()) {
                    throw new OutOfBalanceException();
                }
                balance -= transactionBody.getAmount();
            }
            transactions.add(new Transaction(String.valueOf(transactions.size() + 1), transactionBody.getType(), transactionBody.getAmount(), LocalDateTime.now()));
        } finally {
            writeLock.unlock();
        }
    }
}
