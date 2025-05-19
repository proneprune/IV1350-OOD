package se.kth.iv1350.mjj.view;

import se.kth.iv1350.mjj.controller.SaleController;
import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.util.DatabaseUnreachableException;
import se.kth.iv1350.mjj.util.DisplayInput;
import se.kth.iv1350.mjj.util.ItemNotFoundException;
import se.kth.iv1350.mjj.util.Logger;
import se.kth.iv1350.mjj.util.ConsoleLogger;
import se.kth.iv1350.mjj.util.FileLogger;

public class View {
    private SaleController saleController;
    private Display display;
    Logger[] loggers = new Logger[2];

    /**
     * Creates a new instance of View.
     * 
     * @param saleController The controller that handles the sale process.
     */

    public View(SaleController saleController, Display display) {
        this.display = display;
        this.saleController = saleController;
        loggers[0] = new ConsoleLogger();
        loggers[1] = new FileLogger();
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
        for(int i = 1; i <= 5; i++){
            try{
                displayInput = saleController.scanProduct(i, 1);
                display.updateDisplay(displayInput);
            } catch(ItemNotFoundException e){
                for(Logger logger : loggers) {
                    logger.log("Sorry, that item is not in the system.\nError: " + e);
                }
                //display.showError("Sorry that item is not in the system");
            } catch(DatabaseUnreachableException e){
                for(Logger logger : loggers) {
                    logger.log("The database is unreachable.\nError: " + e);
                }
                //display.showError("The database is unreachable");
            }
        }
        try{
            displayInput = saleController.scanProduct(100, 1);
        } catch (ItemNotFoundException e){
            for(Logger logger : loggers) {
                logger.log("Sorry, that item is not in the system.\nError: " + e);
            }
        } catch(DatabaseUnreachableException e){
            for(Logger logger : loggers) {
                logger.log("The database is unreachable.\nError: " + e);
            }
        }


        double amountToPay = saleController.endSale();
        double change = saleController.enterAmount(amountToPay + 100);

        System.out.printf("Change to return: %.2f%n", change);
        System.out.println("Thank you for shopping with us!");
    
    }
}
