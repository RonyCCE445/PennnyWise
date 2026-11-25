package io.github.ronycce445.pennywise.controller;


import io.github.ronycce445.pennywise.service.TransactionService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import java.util.List;
import io.github.ronycce445.pennywise.entity.Transaction;



@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
  public ResponseEntity<List<Transaction>> getTransactions(){
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @RequestBody Transaction transaction){
        return ResponseEntity.ok(
                transactionService.createTransaction(transaction)
        );
    }
}
