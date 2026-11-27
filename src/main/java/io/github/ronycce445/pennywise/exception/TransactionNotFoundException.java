package io.github.ronycce445.pennywise.exception;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(Long id) {
        super("Transaction not found with ID: "+ id);
    }
}


