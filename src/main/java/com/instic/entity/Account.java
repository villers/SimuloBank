package com.instic.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by mickaelvillers on 20/03/2017.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @NotNull
    private String accountNumber;

    @Column(nullable = false)
    @NotNull
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = User.class)
    @JoinColumn(nullable = false)
    private User user;

    public Account() {
    }

    public Account(String name, String accountNumber, BigDecimal balance, User user) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
