package com.company.service;

import com.company.core.entity.Account;
import com.company.core.entity.Client;
import com.company.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public void createNewAccount(Client client, Account account){
        account.setBalance(BigDecimal.valueOf(1000000));
        accountRepo.saveAccAndClient(client, account);
    }
}
