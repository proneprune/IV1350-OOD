package se.kth.iv1350.mjj.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;
import se.kth.iv1350.mjj.util.Price;


public class Sale {

    private Price price;
    private ArrayList<Entry<ProductDTO, Integer>> productList;

    public Sale() {

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
        this.price.addPrice(product.getPrice(), product.getTaxRate(), quantity);
    }

    public double getRunningTotalPlusVat() {
        return 0;
    }

    public SaleDTO getSaleDTO() {
        return new SaleDTO(price.getTotalPrice(), price.getTotalTaxPrice(), this.productList);
        //return this.productList;
    }

    public void updateDiscount(double discount) {
        //this discount method is not implemented in sem3
    }

    //This method should be in the controller, not in the model.
    // public void printReceipt(double amountPaid, double change) {
    //     Receipt receipt = new Receipt(this.getSaleDTO(), amountPaid, change);

    // }
}
