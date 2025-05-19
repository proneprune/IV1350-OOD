package se.kth.iv1350.mjj.util;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.util.Cost;

public class DisplayInput{
    private ProductDTO currentProduct;
    private int quantity;
    private Cost cost;

    /**
     * Create displayInput object with current product, quantity and cost
     * 
     * @param currentProduct The productDTO of the newly added product
     * @param quantity The amout of the product added
     * @param cost The cost object of the product
     */
    
    public DisplayInput(ProductDTO currentProduct, int quantity, Cost cost) {
        this.currentProduct = currentProduct;
        this.quantity = quantity;
        this.cost = cost;
    }
    /**
     * Returns the currentProduct DTO.
     * @return currentProduct The current productDTO.
     */
    public ProductDTO getCurrentProductDTO(){
        return currentProduct;
    }
    /**
     * Returns the currentProduct quantity.
     * @return quantity The quantity of the product added.
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * Returns the costObject of the currentProduct.
     * @return cost The cost object of the currentProduct.
     */
    public Cost getCost(){
        return cost;
    }

}