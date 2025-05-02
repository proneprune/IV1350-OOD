package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;

public class Display {

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

        System.out.printf("Added %d item%s with ID: %d%n", quantity, ((quantity > 1) ? "s" : ""), currentProduct.getProductID());
        System.out.printf("Item ID: %d%n", currentProduct.getProductID());
        System.out.printf("Item name: %s%n", currentProduct.getProductName());
        System.out.printf("Item cost: %.2f kr%n", currentProduct.getPrice());
        System.out.printf("Item VAT: %.0f%%%n", currentProduct.getTaxRate()*100);
        System.out.printf("Item description: %s%n%n", currentProduct.getProductDesc());

        System.out.printf("Total cost (incl VAT): %.2f kr%n", runningTotal);
        System.out.printf("Total VAT: %.2f%n%n", totalTax);
    }


    
}
