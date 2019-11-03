package com.perevertailo.TransactionManager.controller;

import com.perevertailo.TransactionManager.exceptions.NoSuchTransactionException;
import com.perevertailo.TransactionManager.exceptions.OutOfBalanceException;
import com.perevertailo.TransactionManager.model.Transaction;
import com.perevertailo.TransactionManager.model.TransactionBody;
import com.perevertailo.TransactionManager.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionsController {

    private final TransactionService transactionService;

    TransactionsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> fetchTransactions() {
        return transactionService.getAll();
    }

    @GetMapping("/transactions/{id}")
    public Transaction fetchTransactionById(@PathVariable String id) {
        return transactionService.getById(id);
    }

    @GetMapping("/balance")
    public String fetchBalance() {
        return transactionService.getBalance();
    }

    @PostMapping("/transaction")
    public void addTransaction(@RequestBody @Valid TransactionBody transactionBody){
        transactionService.add(transactionBody);
    }

    @ExceptionHandler({OutOfBalanceException.class, NoSuchTransactionException.class})
    public ResponseEntity<String> handleCustomExceptions(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}