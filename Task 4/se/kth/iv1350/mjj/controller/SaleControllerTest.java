package se.kth.iv1350.mjj.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import se.kth.iv1350.mjj.controller.SaleController;
import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.integration.ExternalAccountingSystem;
import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.util.DatabaseUnreachableException;
import se.kth.iv1350.mjj.util.ItemNotFoundException;

public class SaleControllerTest {

    private SaleController saleController;
    private ExternalInventorySystem externalInventorySystem;
    
    @BeforeEach
    public void setUp() {
        externalInventorySystem = new ExternalInventorySystem();
        saleController = new SaleController(new ExternalAccountingSystem(), externalInventorySystem, new ReceiptPrinter());
        saleController.startSale();
    }

    @AfterEach
    public void tearDown() {
        saleController = null;
    }

    @Test
    public void testScanProductCorrectID() throws ItemNotFoundException, DatabaseUnreachableException {
        ProductDTO expected = new ProductDTO(2, "Mjölk 1L", "Arla mellan mjölk 1L, 1.5% fett", 14.95, 0.12);
        ProductDTO tested = externalInventorySystem.getProductInfo(2);
        assertEquals(expected.getProductID(), tested.getProductID());
        assertEquals(expected.getProductName(), tested.getProductName());
        assertEquals(expected.getProductDesc(), tested.getProductDesc());
        assertEquals(expected.getPrice(), tested.getPrice());
        assertEquals(expected.getTaxRate(), tested.getTaxRate());
    }

    @Test
    public void testDoAPurchase() throws ItemNotFoundException, DatabaseUnreachableException {
        saleController.scanProduct(1, 1);
        double amountToPay = saleController.endSale();
        double change = saleController.enterAmount(amountToPay);
        assertNotEquals(change, -1, "Change is -1 (error).");
        assertNotEquals(change, -2, "Change is -2 (error).");
    }

    @Test
    public void testPayingWithNegativeMoney() throws ItemNotFoundException, DatabaseUnreachableException {
        saleController.scanProduct(1, 1);
        double amountToPay = saleController.endSale();
        amountToPay *= -1;
        double change = saleController.enterAmount(amountToPay);
        assertEquals(change, -1, "Change is not -1 (error).");
    }

    @Test
    public void testPayingInsufficentFunds() throws ItemNotFoundException, DatabaseUnreachableException {
        saleController.scanProduct(1, 1);
        double amountToPay = saleController.endSale();
        amountToPay--;
        double change = saleController.enterAmount(amountToPay);
        assertEquals(change, -2, "Change is not -2 (error).");
    }

    @Test
    public void testScanProductInvalidID() throws ItemNotFoundException, DatabaseUnreachableException {
        assertThrows(ItemNotFoundException.class, ()->{
            saleController.scanProduct(5, 1);
        });
    }

    @Test
    public void testScanProductDatabaseUnreachable() throws ItemNotFoundException, DatabaseUnreachableException {
        assertThrows(DatabaseUnreachableException.class, ()->{
            saleController.scanProduct(100, 1);
        });
    }
}
