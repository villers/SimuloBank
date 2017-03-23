package com.instic.services;

import com.instic.entity.AccountHistory;
import com.instic.repository.AccountHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
@Service
public class AccountHistoryServiceImpl implements AccountHistoryService {
    @Autowired
    private AccountHistoryRepository accountHistoryRepository;

    @Override
    public AccountHistory findOne(long id) {
        return accountHistoryRepository.findOne(id);
    }

    @Override
    public void save(AccountHistory account) {
        accountHistoryRepository.save(account);
    }
}
