package se.kth.iv1350.mjj.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.mjj.model.CashRegister;
import se.kth.iv1350.mjj.model.Sale;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class CashRegisterTest {

    private Sale sale;
    private ProductDTO product;
    private ProductDTO product2;
    private SaleDTO saleDTO;
    private CashRegister cashRegister;
    
    @BeforeEach
    public void setUp() {
        cashRegister = new CashRegister();
        sale = new Sale();
        product = new ProductDTO(0, "Milk", "Tasty milk", 10.0, 0.1);
        product2 = new ProductDTO(1, "Bread", "Fresh bread", 20.0, 0.2);
        sale.addProduct(product, 2);
        sale.addProduct(product2, 1);
        saleDTO = sale.getSaleDTO();
    }

    @AfterEach
    public void tearDown() {
        cashRegister = null;
        sale = null;
        product = null;
        product2 = null;
        saleDTO = null;
    }

    @Test
    public void calculateChangeTest() {
        double expectedChange = 100 - 40;
        assertEquals(expectedChange, cashRegister.calculateChange(100, saleDTO), 0.01, "Change is not correct");

    }




}