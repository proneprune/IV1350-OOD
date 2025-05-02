package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.Receipt;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import java.util.ArrayList;


public class ReceiptPrinter {

    public ReceiptPrinter() {

    }

    public void printReceipt(Receipt saleReceipt){
        System.out.println("Receipt");
        System.out.printf("Date time: %s%n", saleReceipt.getDate());

        ArrayList <ProductDTO> productsInSale = saleReceipt.getFinalSale().getProductsInSale();

        while(productsInSale.size() > 0) {
            ProductDTO currentProduct = productsInSale.remove(0);
            System.out.printf("%s: %f Tax %d%n", currentProduct.getProductDesc(), currentProduct.getPrice(), currentProduct.getTaxRate());
        }

        System.out.printf("Total price: %f%n", saleReceipt.getFinalSale().getRunningTotal());
        System.out.printf("Total Tax: %f%n", saleReceipt.getFinalSale().getTotalTax());
    }
    
}
