package se.kth.iv1350.mjj.view;

import se.kth.iv1350.mjj.controller.SaleController;

public class View {
    private SaleController saleController;

    public View(SaleController saleController) {
        this.saleController = saleController;
    }

    // TESTING
    public void start() {
        System.out.println("Welcome to the store!");
        

        saleController.startSale();
        System.out.println("Starting a new sale...");

        // Simulate adding products to the sale
        saleController.scanProduct(1, 1); // Product ID 1, quantity 2
        saleController.scanProduct(2, 1); // Product ID 2, quantity 1
        saleController.scanProduct(3, 1); // Product ID 2, quantity 1
        saleController.scanProduct(4, 1); // Product ID 2, quantity 1

        double amountToPay = saleController.endSale();
        double change = saleController.enterAmount(amountToPay + 100);

        System.out.printf("Change to return: %.2f%n", change);
        System.out.println("Thank you for shopping with us!");
    
    }
}
