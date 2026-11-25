package io.github.ronycce445.pennywise.repository;
import io.github.ronycce445.pennywise.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
}