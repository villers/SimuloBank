package com.instic.services;

import com.instic.entity.Account;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
public interface AccountService {
    Account findOne(long id);
    void save(Account account);
}
