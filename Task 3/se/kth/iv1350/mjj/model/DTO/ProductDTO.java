package se.kth.iv1350.mjj.model.DTO;

public class ProductDTO {
    private int productID;
    private String productName;
    private String productDesc;
    private double price;
    private double taxRate;


    /**
     * Creates a ProductDTO from the supplied ID, description, price, and tax rate.
     * 
     * @param productID
     * @param productDesc
     * @param price
     * @param taxRate
     */
    public ProductDTO(int productID, String productName, String productDesc, double price, int taxRate) {
        this.productID = productID;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.taxRate = taxRate;
    }

    /**
     * Getter for the product ID.
     * 
     * @return The ID of the product.
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Getter for the product name.
     * 
     * @return The name of the product.
     */

    public String getProductName() {
        return productName;
    }

    /**
     * Getter for the product description.
     * 
     * @return The product description.
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * Getter for the price of the product.
     * 
     * @return The product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for the tax rate of the product.
     * 
     * @return The tax rate of the product.
     */
    public double getTaxRate() {
        return taxRate;
    }
}