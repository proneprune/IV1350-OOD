package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class ExternalAccountingSystem {
    public ExternalAccountingSystem() {
        
    }

    /**
     * A method for updating the accounting system.
     * Not fully implemented as of seminar 3, only prints in terminal.
     * 
     * @param finalSale The final SaleDTO of the sale.
     */
    public void updateAccountingSystem(SaleDTO finalSale) {
        System.out.println("====================================");
        System.out.println(" Accounting system recieved SaleDTO");
        System.out.println("====================================");
    }
}
