package io.github.ronycce445.pennywise.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.github.ronycce445.pennywise.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
public class Transaction {

    protected Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String title;

    @Getter
    @Setter
    @Column(precision = 19, scale = 2,nullable = false)
    private BigDecimal amount;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Getter
    @Setter
    @Column(nullable = false)
    private LocalDate date;

    @Getter
    @Setter
    private String description;

}