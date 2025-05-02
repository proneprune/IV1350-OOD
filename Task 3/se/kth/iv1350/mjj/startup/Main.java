package se.kth.iv1350.mjj.startup;

import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.integration.ExternalAccountingSystem;
import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.controller.SaleController;
import se.kth.iv1350.mjj.view.View;

public class Main {
    public static void main(String[] args) {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Display display = new Display();
        ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();
        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
        SaleController saleController = new SaleController(externalAccountingSystem, externalInventorySystem, receiptPrinter, display);
        View view = new View(saleController);
    }
}
