package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.Receipt;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

import java.util.ArrayList;
import java.util.Map.Entry;

public class ReceiptPrinter {
    public void printReceipt(Receipt saleReceipt){
        SaleDTO finalSale = saleReceipt.getFinalSale();
        ArrayList<Entry<ProductDTO, Integer>> productsInSale = finalSale.getProductsInSale();
        
        System.out.println("------------------ Begin receipt -------------------");
        System.out.printf("Time of Sale: %s%n%n", saleReceipt.getTimeOfSale());

        for(Entry<ProductDTO, Integer> currentProductEntry : productsInSale) {
            ProductDTO currentProduct = currentProductEntry.getKey();
            int currentProductAmount = currentProductEntry.getValue();
            System.out.printf("%s\t%d x %.2f%n\t%.2f",currentProduct.getProductName(),
                                                            currentProductAmount, 
                                                            currentProduct.getPrice(),
                                                            currentProductAmount * currentProduct.getPrice()
                                                            );
        }

        System.out.printf("%nTotal price:\t%f%n", finalSale.getRunningTotal());
        System.out.printf("Total tax:\t%f%n%n", finalSale.getTotalTax());
        System.out.printf("Paid amount:\t%.2f%n", saleReceipt.getAmountPaid());
        System.out.printf("Change:\t%.2f%n", saleReceipt.getChange());
        System.out.println("------------------ End receipt ---------------------");
    }
    
}
