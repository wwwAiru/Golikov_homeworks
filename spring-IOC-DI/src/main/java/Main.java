import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.CNY;
import spring.core.CurrencyConverter;
import spring.core.EUR;
import spring.core.USD;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CurrencyConverter converter = context.getBean("converter", CurrencyConverter.class);
        USD usd = context.getBean("usd", USD.class);
        EUR eur = context.getBean("eur", EUR.class);
        CNY cny = context.getBean("cny", CNY.class);
        converter.addCurrencyToList(usd);
        converter.addCurrencyToList(eur);
        converter.addCurrencyToList(cny);
        System.out.println(converter.getExchangeableCurrencies());
        converter.exchangeTo("EUR");
        System.out.println(converter);
        converter.exchangeToRUB();
        converter.exchangeTo("USD");
        System.out.println(converter);
        converter.exchangeToRUB();
        converter.exchangeTo("CNY");
        System.out.println(converter);
        converter.exchangeToRUB();
    }
}
