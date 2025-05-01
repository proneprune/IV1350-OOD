package se.kth.iv1350.mjj.model.DTO;

public class ProductDTO {
    private int productID;
    private String productDesc;
    private double price;
    private double taxRate;

    ProductDTO(int productID, String productDesc, double price, int taxRate) {
        this.productID = productID;
        this.productDesc = productDesc;
        this.price = price;
        this.taxRate = taxRate;
    }
    public double getPrice() {
        return price;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public int getProductID() {
    return productID;
    }
    public double getTaxRate() {
        return taxRate;
    }
}