package com.instic.entity;

/**
 * Created by mickaelvillers on 22/03/2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TransactionType {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "type")
    private List<AccountHistory> accountHistories;

    public TransactionType() {
    }

    public TransactionType(String name) {
        this.name = name;
        this.accountHistories = new ArrayList<>();
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

    public List<AccountHistory> getAccountHistories() {
        return accountHistories;
    }

    public void setAccountHistories(List<AccountHistory> accountHistories) {
        this.accountHistories = accountHistories;
    }
}
