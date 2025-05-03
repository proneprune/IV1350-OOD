package se.kth.iv1350.mjj.tests.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import se.kth.iv1350.mjj.model.Sale;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;

public class SaleTest {

    private Sale sale;
    private ProductDTO product;
    
    @BeforeEach
    public void setUp() {
        sale = new Sale();
        product = new ProductDTO(0, "Milk", "Tasty milk", 10.0, 0.1);
    }

    @AfterEach
    public void tearDown() {
        sale = null;
        product = null;
    }

    @Test
    public void testAddNewProduct() {
        sale.addProduct(product, 2);
        double expectedTotal = 2 * 10.0;
        double expectedTax = 2 * (10 - (10.0 / 1.1)) ;

        assertEquals(expectedTotal, sale.getRunningTotalPlusVat(), 0.0001, "Total cost with VAT should be correct");
        assertEquals(expectedTax, sale.getTotalTax(), 0.0001, "Tax cost should be correct");
    }


}
