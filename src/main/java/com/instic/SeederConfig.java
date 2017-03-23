package com.instic;

import com.instic.entity.AccountType;
import com.instic.entity.TransactionType;
import com.instic.services.AccountTypeService;
import com.instic.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mickaelvillers on 21/03/2017.
 */

@Configuration
public class SeederConfig {
    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    private TransactionTypeService transactionTypeService;

    @Bean
    public boolean seed() {
        if (accountTypeService.findAll().isEmpty()) {
            accountTypeService.save(new AccountType("Pel"));
            accountTypeService.save(new AccountType("Livret A"));
            accountTypeService.save(new AccountType("Compte Courrant"));
            accountTypeService.save(new AccountType("Compte Epargne"));
        }

        if (transactionTypeService.findAll().isEmpty()) {
            transactionTypeService.save(new TransactionType("Negative"));
            transactionTypeService.save(new TransactionType("Positive"));
        }
        return true;
    }
}
