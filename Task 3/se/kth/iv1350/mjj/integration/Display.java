package se.kth.iv1350.mjj.integration;

import java.util.ArrayList;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Display {
    private double runningTotal;
    private double totalTax;

    /**
     * Creates a new instance of Display.
     */
    public Display() {
    }

    /**
     * Updates the display with the current product and quantity.
     * aswell as all the relevant information about the product.
     * 
     * it also calculates running total and total tax for this instance of the sale.
     * 
     * @param currentProduct The current product to be displayed.
     * @param quantity       The quantity of the current product.
     */
    public void updateDisplay(ProductDTO currentProduct, int quantity, double runningTotal, double totalTax) {

        System.out.printf("Added %d Item with ID: %d%n", quantity, currentProduct.getProductID());
        System.out.printf("Item ID: %d%n", currentProduct.getProductID());
        System.out.printf("Item name: %s%n", currentProduct.getProductName());
        System.out.printf("Item cost: %f%n", currentProduct.getPrice());
        System.out.printf("Item VAT: %f%n", currentProduct.getTaxRate());
        System.out.printf("Item description: %s%n", currentProduct.getProductDesc());

        System.out.printf("Total cost (incl VAT): %f%n", runningTotal);
        System.out.printf("Total VAT: %f%n", totalTax);
    }


    
}
