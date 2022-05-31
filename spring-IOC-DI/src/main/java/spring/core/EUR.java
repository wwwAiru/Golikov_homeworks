package spring.core;

public class EUR implements Rateable {
    private double rate;
    private final String currency = "EUR";

    public EUR() {
    }

    public EUR(double rate) {
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
