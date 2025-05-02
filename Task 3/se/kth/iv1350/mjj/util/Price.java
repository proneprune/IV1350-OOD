package se.kth.iv1350.mjj.util;

public class Price {
    private double price;
    private double taxRate;

    /**
     * Creates a Price object with the given price and tax rate.
     * @param price the price of the product
     * @param taxRate the tax rate of the product
     */
    public Price(double price, double taxRate) {
        this.price = price;
        this.taxRate = taxRate;
    }

    /**
     * getter for the price of the product.
     * 
     * @return the price of the product
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * getter for the tax rate of the product.
     * 
     * @return the tax rate of the product
     */
    public double getTaxRate() {
        return this.taxRate;
    }
}
