package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.Receipt;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;

import java.util.ArrayList;
import java.util.Map.Entry;

public class ReceiptPrinter {

    /**
     * Creates a new instance of ReceiptPrinter.
     * This class is responsible for printing the receipt to the console.
     */

    public ReceiptPrinter() {

    }

    /**
     * Prints the receipt to the console.
     * 
     * @param saleReceipt The receipt to be printed.
     */

    public void printReceipt(Receipt saleReceipt){
        SaleDTO finalSale = saleReceipt.getFinalSale();
        ArrayList<Entry<ProductDTO, Integer>> productsInSale = finalSale.getProductsInSale();
        
        System.out.println("------------------ Begin receipt -------------------");
        System.out.printf("Time of Sale: %s%n%n", saleReceipt.getTimeOfSale());

        for(Entry<ProductDTO, Integer> currentProductEntry : productsInSale) {
            ProductDTO currentProduct = currentProductEntry.getKey();
            int currentProductAmount = currentProductEntry.getValue();
            System.out.printf("%-23s\t%d x %.2f\t%.2f%n",currentProduct.getProductName(),
                                                            currentProductAmount, 
                                                            currentProduct.getPrice(),
                                                            currentProductAmount * currentProduct.getPrice()
                                                            );
        }

        System.out.printf("%nTotal price:\t%.2f kr%n", finalSale.getRunningTotal());
        System.out.printf("Total tax:\t%.2f%n%n", finalSale.getTotalTax());
        System.out.printf("Paid amount:\t%.2f kr%n", saleReceipt.getAmountPaid());
        System.out.printf("Change:\t%.2f kr%n", saleReceipt.getChange());
        System.out.println("------------------ End receipt ---------------------");
    }

}
