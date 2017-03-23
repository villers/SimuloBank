package com.instic.services;

import com.instic.entity.AccountHistory;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
public interface AccountHistoryService {
    AccountHistory findOne(long id);
    void save(AccountHistory account);
}
