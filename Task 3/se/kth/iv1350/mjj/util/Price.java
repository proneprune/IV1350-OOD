package se.kth.iv1350.mjj.util;

public class Price {
    private double price;
    private double taxRate;
    
    public Price(double price, double taxRate) {
        this.price = price;
        this.taxRate = taxRate;
    }

    public double getPrice() {
        return this.price;
    }

    public double getTaxRate() {
        return this.taxRate;
    }
}
