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


    /**
     *  Creates a Sale object with an empty list of products and a price object.
     */ 
    public Sale() {
        this.price = new Price();
        this.productList = new ArrayList<Entry<ProductDTO, Integer>>();
    }

    /**
     * Adds a product to the sale. If the product already exists in the list, it updates the quantity.
     * 
     * @param product The product to be added to the sale.
     * @param quantity The amount of the product to be added.
     */
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


    /**
     * Gets the total price of the Sale.
     * Since VAT is included in the price in the inventory, get total price 
     * is the total price including VAT.
     * 
     * @return The total price of the sale including VAT.
     */
    public double getRunningTotalPlusVat() {
        return this.price.getTotalPrice();
    }

    /**
     * Creates a SaleDTO object from the current sale.
     * 
     * @return A SaleDTO object containing the total price, total tax price, and list of products in the sale.
     */
    public SaleDTO getSaleDTO() {
        return new SaleDTO(this.price.getTotalPrice(), this.price.getTotalTaxPrice(), this.productList);
        //return this.productList;
    }

    /**
     * Updates the discount for the sale.
     * This method is not implemented in sem3.
     * 
     * @param discount The discount to be applied to the sale.
     */
    public void updateDiscount(double discount) {
        //this discount method is not implemented in sem3
    }

}
