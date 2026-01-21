package com.filipszlagowski.ledger.account.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatyczna inkrementacja
    private Long id;

    @Column(nullable = false)
    private BigDecimal balance;

    private String name;

}
