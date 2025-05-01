package se.kth.iv1350.mjj.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;


public class Sale {
    private double runningTotal;
    private double totalTax;
    private ArrayList<Entry<ProductDTO, Integer>> productList;

    public Sale() {
        this.runningTotal = 0;
        this.totalTax = 0;
        this.productList = new ArrayList<Entry<ProductDTO, Integer>>();
    }

    public void addProduct(ProductDTO product, int quantity) {
        boolean productExists = false;
        for (Entry<ProductDTO, Integer> entry : this.productList) {
            if (entry.getKey().getProductID() == product.getProductID()) {
                productExists = true;
                entry.setValue(entry.getValue() + quantity);
                break;
            }
        }
        if (!productExists){
            Entry<ProductDTO, Integer> test = new SimpleEntry<>(product, quantity);
            this.productList.add(test);
        }   
        this.runningTotal += product.getPrice() * quantity * (1 + product.getTaxRate());//kanske behöver /100 beroende på tax ser ut
        this.totalTax += product.getPrice() * quantity * product.getTaxRate();//kanske behöver /100 beroende på tax ser ut 
       
    }

    public double getRunningTotalPlusVat() {
        return 0;
    }

    public SaleDTO getSaleDTO() {
        //return this.productList;
    }

    public void updateDiscount(double discount) {
        //this discount method is not implemented in sem3
    }

    public void printReceipt(double amountPaid, double change) {
        Receipt receipt = new Receipt(this.getSaleDTO(), amountPaid, change);
        
    }
}
