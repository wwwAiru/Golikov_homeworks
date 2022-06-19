package spring.core;

public class CNY implements Rateable {
    private double rate;
    private final String currency = "CNY";


    public CNY() {
    }

    public CNY(double rate) {
        this.rate = rate;
    }

    @Override
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "{" +
                "rate=" + rate +
                '}';
    }
}
