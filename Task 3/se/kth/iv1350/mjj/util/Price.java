package se.kth.iv1350.mjj.util;

public class Price {

    private double totalPrice;
    private double totalTaxPrice;

    
    /**
     * Creates a Price object with initial values of 0 for total price and total tax price.
     */
    public Price() {
        this.totalPrice = 0;
        this.totalTaxPrice = 0;
    }

    /**
     * Adds the price to the total price and calculates the tax price based on the given tax rate and 
     * adds that to the total tax price.
     * 
     * @param price The price of the product to be added.
     * @param taxRate the tax rate of the product to be added.
     */
    public void addPrice(double price, int taxRate) {
        this.totalPrice += price;
        this.totalTaxPrice += price - (price / ((taxRate / 100.0) + 1));
    }

    /**
     * Returns the total price of the products added so far.
     * 
     * @return The total price of the products added so far.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the total tax price of the products added so far.
     * 
     * @return The total tax price of the products added so far.
     */
    public double getTotalTaxPrice() {
        return totalTaxPrice;
    }
    
}
