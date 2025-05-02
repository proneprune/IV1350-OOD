package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.Receipt;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

import java.util.ArrayList;
import java.util.Map.Entry;

public class ReceiptPrinter {
    public void printReceipt(Receipt saleReceipt){
        SaleDTO finalSale = saleReceipt.getFinalSale();
        System.out.println("------------------ Begin receipt -------------------");
        System.out.printf("Time of Sale: %s%n", saleReceipt.getTimeOfSale());

        ArrayList<Entry<ProductDTO, Integer>> productsInSale = finalSale.getProductsInSale();

        for(Entry<ProductDTO, Integer> currentProductEntry : productsInSale) {
            ProductDTO currentProduct = currentProductEntry.getKey();
            int currentProductAmount = currentProductEntry.getValue();
            System.out.printf("%s\t%d x %.2f%n\t%.2f",currentProduct.getProductName(),
                                                            currentProductAmount, 
                                                            currentProduct.getPrice(),
                                                            currentProductAmount * currentProduct.getPrice()
                                                            );
        }

        System.out.printf("Total price: %f%n", finalSale.getRunningTotal());
        System.out.printf("Total tax: %f%n", finalSale.getTotalTax());
        System.out.println("------------------ End receipt ---------------------");
    }
    
}
