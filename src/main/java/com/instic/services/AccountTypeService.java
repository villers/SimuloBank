package com.instic.services;

import com.instic.entity.AccountType;

import java.util.List;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
public interface AccountTypeService {
    List<AccountType> findAll();
    void save(AccountType type);
}
