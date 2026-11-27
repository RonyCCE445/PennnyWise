package io.github.ronycce445.pennywise.service;
import io.github.ronycce445.pennywise.exception.TransactionNotFoundException;
import java.util.List;

import io.github.ronycce445.pennywise.entity.Transaction;
import io.github.ronycce445.pennywise.repository.TransactionRepository;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }
    public Transaction updateTransaction(Long id,Transaction updatedTransaction){
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(()-> new TransactionNotFoundException(id));
        existingTransaction.setTitle(updatedTransaction.getTitle());
        existingTransaction.setAmount(updatedTransaction.getAmount());
        existingTransaction.setType(updatedTransaction.getType());
        existingTransaction.setDate(updatedTransaction.getDate());
        existingTransaction.setDescription(updatedTransaction.getDescription());

        return transactionRepository.save(existingTransaction);
    }

    public void deleteTransaction(Long id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(()-> new TransactionNotFoundException(id));

        transactionRepository.delete(transaction);
    }
}