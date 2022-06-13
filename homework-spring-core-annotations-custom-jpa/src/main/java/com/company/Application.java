package com.company;

import com.company.core.entity.Account;
import com.company.core.entity.Client;
import com.company.core.stocks.AbstractFX;
import com.company.core.stocks.MarketEtf;
import com.company.repo.AccountRepo;
import com.company.service.AccountService;
import com.company.service.StocksMarketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.company");
        MarketEtf marketEtf = applicationContext.getBean(MarketEtf.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        AccountRepo accountRepo = applicationContext.getBean(AccountRepo.class);
        StocksMarketService stocksMarketService = new StocksMarketService(marketEtf, accountRepo);
        Map<Integer, AbstractFX> mapEtf = stocksMarketService.createMapEtf();
        System.out.print("Привествуем Вас! Зарегистрируйтесь чтобы попробовать торговлю на фондовом рынке. \nВведите имя: ");
        String name = scanner.nextLine();
        Client client = new Client();
        client.setName(name);
        System.out.print("Теперь вам нужно открыть счёт, придумайте пароль: ");
        Account account = new Account();
        String password = scanner.nextLine();
        account.setPassword(password);
        accountService.createNewAccount(client, account);
        System.out.println(client.getName() + ", Вы зарегистрировались, на ваш демо-счёт зачислена сумма: 1000000");
        System.out.println("Для инвестирования предлагаем один из трёх фондов: ");
        mapEtf.entrySet().forEach(System.out::println);
        System.out.println("1 - купить FXUS");
        System.out.println("2 - купить FXRL");
        System.out.println("3 - купить FXCN");
        System.out.print("Введите цифру: ");
        Integer choise = scanner.nextInt();
        stocksMarketService.saveChoise(choise, name);

        while (true) {
            System.out.println("Прошёл год, котировки изменились: ");
            Map<Integer, AbstractFX> mapEtfCycle = stocksMarketService.createMapEtf();
            mapEtfCycle.entrySet().forEach(System.out::println);
            System.out.println("Если хотите продать сейчас нажмите  1 \n если хотите подождать нажмите  2");
            int lastChoise = scanner.nextInt();
            if (lastChoise == 1){
                stocksMarketService.saleEtf();
                break;
            }
        }





    }
}
