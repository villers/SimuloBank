package com.instic.services;

import com.instic.entity.TransactionType;
import com.instic.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mickaelvillers on 21/03/2017.
 */
@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public List<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }

    @Override
    public void save(TransactionType type) {
        transactionTypeRepository.save(type);
    }
}
