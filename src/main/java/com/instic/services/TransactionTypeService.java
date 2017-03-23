package com.instic.services;

import com.instic.entity.TransactionType;

import java.util.List;

/**
 * Created by mickaelvillers on 22/03/2017.
 */
public interface TransactionTypeService {
    List<TransactionType> findAll();
    void save(TransactionType type);
}
