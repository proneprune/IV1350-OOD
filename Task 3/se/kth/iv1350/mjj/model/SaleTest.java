package se.kth.iv1350.mjj.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import se.kth.iv1350.mjj.model.Sale;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class SaleTest {

    private Sale sale;
    private ProductDTO product;
    private ProductDTO product2;
    private SaleDTO saleDTO;
    
    @BeforeEach
    public void setUp() {
        sale = new Sale();
        product = new ProductDTO(0, "Milk", "Tasty milk", 10.0, 0.1);
        product2 = new ProductDTO(1, "Bread", "Fresh bread", 20.0, 0.2);

    }

    @AfterEach
    public void tearDown() {
        sale = null;
        product = null;
        product2 = null;
        saleDTO = null;
    }

    @Test
    public void testPriceOfSale() {
        sale.addProduct(product, 2);
        //product1
        double expectedTotal = 2 * 10.0;
        double expectedTax = 2 * (10 - (10.0 / 1.1)) ;

        sale.addProduct(product2, 1);
        //product2
        expectedTotal += 1 * 20.0;
        expectedTax += 1 * (20 - (20.0 / 1.2)) ;



        assertEquals(expectedTotal, sale.getRunningTotalPlusVat(), 0, "Total cost with VAT is not correct");
        assertEquals(expectedTax, sale.getTotalTax(), 0, "Tax cost is not correct");
    }

    @Test
    public void testAddProduct() {
        sale.addProduct(product, 2);
        saleDTO = sale.getSaleDTO();
        assertEquals(product, saleDTO.getProductsInSale().get(0).getKey(), "Product is not correct");
        assertEquals(2, saleDTO.getProductsInSale().get(0).getValue(), "Product quantity is not correct");
    }

    @Test
    public void testAddAlreadyExistingProduct(){
        sale.addProduct(product, 1);
        sale.addProduct(product, 1);
        saleDTO = sale.getSaleDTO();
        assertEquals(product, saleDTO.getProductsInSale().get(0).getKey(), "Product is not correct");
        assertEquals(2, saleDTO.getProductsInSale().get(0).getValue(), "Product quantity is not correct");
    }


}
