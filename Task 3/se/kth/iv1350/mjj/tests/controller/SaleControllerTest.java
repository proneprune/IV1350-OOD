package se.kth.iv1350.mjj.tests.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import se.kth.iv1350.mjj.controller.SaleController;
import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.integration.ExternalAccountingSystem;
import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.integration.ReceiptPrinter;

public class SaleControllerTest {

    private SaleController saleController;
    
    @BeforeEach
    public void setUp() {
        saleController = new SaleController(new ExternalAccountingSystem(), new ExternalInventorySystem(), new ReceiptPrinter(), new Display());
        saleController.startSale();
    }

    @AfterEach
    public void tearDown() {
        saleController = null;
    }

    @Test
    public void testScanProductCorrectID() {
        saleController.scanProduct(1, 1);
    }
}
