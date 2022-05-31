package spring.core;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private Double balance;
    private Map<String, Rateable> exchangeableCurrencies = new HashMap();
    private String currency = "RUB";

    public CurrencyConverter() {
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Map<String, Rateable> getExchangeableCurrencies() {
        return exchangeableCurrencies;
    }

    public void setExchangeableCurrencies(Map<String, Rateable> exchangeableCurrencies) {
        this.exchangeableCurrencies = exchangeableCurrencies;
    }


    public <T> void addCurrencyToList(T _currency) {
        if (_currency == null) {
            exchangeableCurrencies = new HashMap();
        }
        exchangeableCurrencies.put(_currency.getClass().getSimpleName(), (Rateable) _currency);
    }

    public void exchangeTo(String currencyTicker){
        double _rate = (exchangeableCurrencies.get(currencyTicker)).getRate();
        this.balance = this.balance / _rate;
        this.currency = currencyTicker;
        System.out.println("Ваши рубли были обменяны на " + currencyTicker);
    }

    public void exchangeToRUB(){
        if (this.currency != "RUB") {
            double _rate = (exchangeableCurrencies.get(currency)).getRate();
            this.balance = this.balance * _rate;
            this.currency = "RUB";
        }else {
            System.out.println("Валюта баланса уже RUB");
        }
    }

    @Override
    public String toString() {
        return "CurrencyConverter{" +
                "balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
