package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class DiscountCatalog {

    public DiscountCatalog() {

    }

    /**
     * This method will get discount for a sale. It is not implemented for sem3.
     * The discount will be based on customer id and information from the sale.
     * 
     * @param saleToDiscount The sale which the discount will be applied to.
     * @param costumerId   The customer id of the customer who is buying the products.
     * @return The discount for the sale.
     */

    public double getDiscount(SaleDTO saleToDiscount, int costumerId) {
        return 0;
    }
}