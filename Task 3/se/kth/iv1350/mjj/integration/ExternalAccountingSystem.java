package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class ExternalAccountingSystem {
    public ExternalAccountingSystem() {
        
    }

    public void updateAccountingSystem(SaleDTO finalSale) {
        System.out.println("====================================");
        System.out.println(" Accounting system recieved SaleDTO");
        System.out.println("====================================");
    }
}
