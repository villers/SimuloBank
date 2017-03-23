package com.instic.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
@Entity
public class AccountType {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "type")
    private List<Account> account;

    public AccountType() {
    }

    public AccountType(String name) {
        this.name = name;
        this.account = new ArrayList<>();
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

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}