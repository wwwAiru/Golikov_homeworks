package com.company.repo;

import com.company.core.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>, AccountRepoCustom {

    Account findByClient_Name(String name);

    List<Account> findAllByOrderByBalanceDesc();

}
