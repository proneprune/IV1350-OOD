package se.kth.iv1350.mjj.util;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.util.Cost;

public class DisplayInput{
    private ProductDTO currentProduct;
    private int quantity;
    private Cost cost;
    
    public DisplayInput(ProductDTO currentProduct, int quantity, Cost cost) {
        this.currentProduct = currentProduct;
        this.quantity = quantity;
        this.cost = cost;
    }
    public ProductDTO getCurrentProductDTO(){
        return currentProduct;
    }
    public int getQuantity(){
        return quantity;
    }
    public Cost getCost(){
        return cost;
    }


}