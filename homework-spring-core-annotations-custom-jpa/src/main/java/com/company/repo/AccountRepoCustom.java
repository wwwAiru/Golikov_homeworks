package com.company.repo;

import com.company.core.entity.Account;
import com.company.core.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepoCustom {
    void saveAccAndClient(Client client, Account account);
}
