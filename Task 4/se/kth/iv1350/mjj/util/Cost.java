package se.kth.iv1350.mjj.util;

public class Cost {

    private double totalCost;
    private double totalTaxCost;

    

    
    /**
     * Creates a Cost object with initial values of 0 for total Cost and total tax Cost.
     */
    public Cost() {
        this.totalCost = 0;
        this.totalTaxCost = 0;
    }

    /**
     * Adds the Cost to the total Cost and calculates the tax Cost based on the given tax rate and 
     * adds that to the total tax Cost.
     * 
     * @param Cost The Cost of the product to be added.
     * @param taxRate the tax rate of the product to be added.
     * @param quantity The quantity of the product to be added.
     */
    public void addCost(double Cost, double taxRate, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.totalCost += Cost;
            this.totalTaxCost += Cost - (Cost / (taxRate + 1));
        }
    }

    /**
     * Returns the total Cost of the products added so far.
     * 
     * @return The total Cost of the products added so far.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Returns the total tax Cost of the products added so far.
     * 
     * @return The total tax Cost of the products added so far.
     */
    public double getTotalTaxCost() {
        return totalTaxCost;
    }
}
