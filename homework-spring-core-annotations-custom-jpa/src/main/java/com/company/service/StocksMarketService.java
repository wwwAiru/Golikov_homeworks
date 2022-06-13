package com.company.service;

import com.company.core.entity.Account;
import com.company.core.stocks.AbstractFX;
import com.company.core.stocks.MarketEtf;
import com.company.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StocksMarketService {

    private final MarketEtf marketEtf;

    private Map<Integer, AbstractFX> stateEtf;

    private final AccountRepo accountRepo;

    private int choise;
    private int etfCount;
    private Long accId;

    public Map<Integer, AbstractFX> createMapEtf() {
        Map<Integer, AbstractFX> etfMap = new HashMap<>();
        etfMap.put(1, marketEtf.getFXUS());
        etfMap.put(2, marketEtf.getFXRL());
        etfMap.put(3, marketEtf.getFXCN());
        this.stateEtf = etfMap;
        return etfMap;
    }

    public void saveChoise(int clientChoise, String name){
        this.choise = clientChoise;
        AbstractFX clientEtf = stateEtf.get(clientChoise);
        Account account = accountRepo.findByClient_Name(name);
        this.accId = account.getId();
        Integer currentBalance = account.getBalance().intValue();
        Integer clientEtfPrice = clientEtf.getPrice().intValue();
        Integer afterBuyBalance = currentBalance%clientEtfPrice;
        this.etfCount = currentBalance/clientEtfPrice;
        account.setBalance(BigDecimal.valueOf(afterBuyBalance));
        accountRepo.save(account);
    }

    public void saleEtf() {
        Optional<Account> acc = accountRepo.findById(this.accId);
        Account account = acc.get();
        AbstractFX etfForSale = stateEtf.get(this.choise);
        BigDecimal clientAccBalance = account.getBalance();
        Integer clientEtfCost = etfForSale.getPrice().intValue()*etfCount;
        BigDecimal actualBalance = BigDecimal.valueOf(clientAccBalance.intValue() + clientEtfCost);
        account.setBalance(actualBalance);
        accountRepo.save(account);
        System.out.println("Вы продали свой актив, ваш баланс = " + actualBalance);
        List<Account> table = accountRepo.findAllByOrderByBalanceDesc();
        for (Account accCl : table){
            System.out.println(accCl.getClient().getName()+" "+accCl.getBalance());
        }
    }
}
