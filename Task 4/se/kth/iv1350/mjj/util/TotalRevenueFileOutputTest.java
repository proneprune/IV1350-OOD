package se.kth.iv1350.mjj.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.model.Sale;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;

public class TotalRevenueFileOutputTest {
    private double cost;
    private Sale sale;
    private ProductDTO product;
    private ProductDTO product2;
    private ExternalInventorySystem externalInventorySystem;

    @BeforeEach
    public void setUp() throws ItemNotFoundException, DatabaseUnreachableException {
        cost = 0;
        sale = new Sale();
        externalInventorySystem = new ExternalInventorySystem();
        product = externalInventorySystem.getProductInfo(1);
        product2 = externalInventorySystem.getProductInfo(2);
    }

    @AfterEach
    public void tearDown() {
        sale = null;
        product = null;
        product2 = null;
        cost = 0;
    }

    @Test
    public void testUpdateRevenue() throws FileNotFoundException, IOException {
        sale.addProduct(product, 1);
        cost = sale.getRunningTotalPlusVat();
        double revenue;
        
        revenue = getRevenueStringFromFile();

        assertEquals(revenue, cost, "Revenue in file not equal to sale cost.");
    }

    @Test
    public void testUpdateRevenueWithTwoSales() throws FileNotFoundException, IOException{
        sale.addProduct(product, 1);
        cost = sale.getRunningTotalPlusVat();
        Sale sale2 = new Sale();
        sale2.addProduct(product2, 1);
        double cost2 = sale.getRunningTotalPlusVat();
        double revenue = getRevenueStringFromFile();
        assertEquals(revenue, cost + cost2, "Revenue in file not equal to sale costs.");
    }

    private double getRevenueStringFromFile() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("revenueLog.txt"));
        String revenueString = br.readLine();
        br.close();
        int indexOfDoubleInString = 3;
        double revenue = Double.parseDouble(revenueString.split(" ")[indexOfDoubleInString]);
        
        return revenue;
    }
    
}
