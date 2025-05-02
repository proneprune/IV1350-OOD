package se.kth.iv1350.mjj.integration;

import java.util.ArrayList;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Display {


    public Display() {

    }

    public void updateDisplay(SaleDTO currentSale) {
        ArrayList <ProductDTO> productsInSale = currentSale.getProductsInSale();
        ProductDTO addedProduct = productsInSale.get(productsInSale.size()-1);
        System.out.printf("Added 1 Item with ID: %d%n", addedProduct.getProductID());
        System.out.printf("Item ID: %d%n", addedProduct.getProductID());
        System.out.printf("Product name: %s%n", addedProduct.getProductName());
        System.out.printf("Item cost: %f%n", addedProduct.getPrice());
        System.out.printf("Item VAT: %f%n", addedProduct.getTaxRate());
        System.out.printf("Item description: %s%n", addedProduct.getProductDesc());
        System.out.printf("Total cost (incl VAT): %f%n", currentSale.getRunningTotal());
        System.out.printf("Total VAT: %f%n", currentSale.getTotalTax());
    }
    
}
