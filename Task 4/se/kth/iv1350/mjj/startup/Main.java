package se.kth.iv1350.mjj.startup;

import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.integration.ExternalAccountingSystem;
import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.controller.SaleController;
import se.kth.iv1350.mjj.view.View;

public class Main {

    /**
     * The method responsible for the startup of the program.
     * It creates all systems in order according to the diagram.
     * 
     * @param args Additional arguments (Not in use)
     */
    public static void main(String[] args) {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Display display = new Display();
        ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
        SaleController saleController = new SaleController(externalAccountingSystem, externalInventorySystem, receiptPrinter);
        View view = new View(saleController, display);
        view.start();
    }
}
