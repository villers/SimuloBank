package com.instic.services;

import com.instic.entity.AccountType;
import com.instic.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }

    @Override
    public void save(AccountType type) {
        accountTypeRepository.save(type);
    }
}
