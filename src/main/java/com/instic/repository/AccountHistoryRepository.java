package com.instic.repository;

import com.instic.entity.AccountHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mickaelvillers on 20/03/2017.
 */

@Repository
public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Long> {

}
