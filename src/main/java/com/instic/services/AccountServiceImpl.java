package com.instic.services;

import com.instic.entity.Account;
import com.instic.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findOne(long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
