package com.company.repo;

import com.company.core.entity.Account;
import com.company.core.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AccountRepoCustomImpl implements AccountRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveAccAndClient(Client client, Account account) {
        account.setClient(client);
        client.setAccount(account);
        entityManager.persist(client);
        entityManager.flush();
    }
}
