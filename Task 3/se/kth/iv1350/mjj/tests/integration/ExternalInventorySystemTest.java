package se.kth.iv1350.mjj.tests.integration;

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

public class ExternalInventorySystemTest {

    private SaleController saleController;
    
    @BeforeEach
    public void setUp() {
        
    }

    @AfterEach
    public void tearDown() {
        
        
    }

    @Test
    public void testScanProductCorrectID() {


    }
}
