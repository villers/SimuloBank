package com.instic.repository;

import com.instic.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mickaelvillers on 20/03/2017.
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
