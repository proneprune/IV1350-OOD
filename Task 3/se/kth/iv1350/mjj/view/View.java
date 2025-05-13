package se.kth.iv1350.mjj.view;

import se.kth.iv1350.mjj.controller.SaleController;
import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.util.DisplayInput;

public class View {
    private SaleController saleController;
    private Display display;

    /**
     * Creates a new instance of View.
     * 
     * @param saleController The controller that handles the sale process.
     */

    public View(SaleController saleController, Display display) {
        this.saleController = saleController;
        this.display = display;
    }

    // TESTING
    /**
     * * This method simulates a sale process. It starts a new sale, scans products,
     * enters the amount paid by the customer, and prints the change to be returned.
     */
    public void start() {
        System.out.println("Welcome to the store!");
        DisplayInput displayInput;
        

        saleController.startSale();
        System.out.println("Starting a new sale...");

        // Simulate adding products to the sale
        displayInput = saleController.scanProduct(1, 1); // Product ID 1, quantity 2
        display.updateDisplay(displayInput.getCurrentProductDTO(), displayInput.getQuantity(), displayInput.getCost());
        displayInput = saleController.scanProduct(2, 1); // Product ID 2, quantity 1
        display.updateDisplay(displayInput.getCurrentProductDTO(), displayInput.getQuantity(), displayInput.getCost());
        displayInput = saleController.scanProduct(3, 1); // Product ID 2, quantity 1
        display.updateDisplay(displayInput.getCurrentProductDTO(), displayInput.getQuantity(), displayInput.getCost());
        displayInput = saleController.scanProduct(4, 1); // Product ID 2, quantity 1
        display.updateDisplay(displayInput.getCurrentProductDTO(), displayInput.getQuantity(), displayInput.getCost());

        double amountToPay = saleController.endSale();
        double change = saleController.enterAmount(amountToPay + 100);

        System.out.printf("Change to return: %.2f%n", change);
        System.out.println("Thank you for shopping with us!");
    
    }
}
