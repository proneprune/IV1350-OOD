package se.kth.iv1350.mjj.integration;

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
import se.kth.iv1350.mjj.util.ItemNotFoundException;
import se.kth.iv1350.mjj.util.DatabaseUnreachableException;

public class ExternalInventorySystemTest {

    private ExternalInventorySystem externalInventorySystem;
    
    @BeforeEach
    public void setUp() {
        externalInventorySystem = new ExternalInventorySystem();
    }

    @AfterEach
    public void tearDown() {
        externalInventorySystem = null;
    }

    @Test
    public void testGetProductInfoValidID() throws ItemNotFoundException, DatabaseUnreachableException {
        ProductDTO expected = new ProductDTO(2, "Mjölk 1L", "Arla mellan mjölk 1L, 1.5% fett", 14.95, 0.12);
        ProductDTO tested = externalInventorySystem.getProductInfo(2);
        assertEquals(expected.getProductID(), tested.getProductID());
        assertEquals(expected.getProductName(), tested.getProductName());
        assertEquals(expected.getProductDesc(), tested.getProductDesc());
        assertEquals(expected.getPrice(), tested.getPrice());
        assertEquals(expected.getTaxRate(), tested.getTaxRate());
    }
    
    @Test
    public void testGetProductInfoInvalidID() throws ItemNotFoundException, DatabaseUnreachableException {
        assertThrows(ItemNotFoundException.class, ()->{
            ProductDTO tested = externalInventorySystem.getProductInfo(5);
        });
    }
}
