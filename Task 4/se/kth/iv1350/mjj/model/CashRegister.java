package se.kth.iv1350.mjj.model;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class CashRegister {
    
    private double cashInRegister;
    private static final double STARTING_CHANGE_AMOUNT = 0;

    /**
     * Creates a cash register containing a starting amount of <code>STARTING_CHANGE_AMOUNT</code>
     */
    public CashRegister() {
        cashInRegister = STARTING_CHANGE_AMOUNT;
    }

    /**
     * Calculates the change to give back to the customer.
     * 
     * @param paymentAmount The amount paid by the customer
     * @param finalSale     The SaleDTO containing the running total and total tax.
     * @return The calculated change to give back.
     */
    public double calculateChange(double paymentAmount, SaleDTO finalSale) {
        double totalCost = finalSale.getRunningTotal();
        double changeToGiveBack = paymentAmount - totalCost;
        updateCashInRegister(totalCost);
        return changeToGiveBack;
    }

    private void updateCashInRegister(double change) {
        cashInRegister += change;
    }
}
