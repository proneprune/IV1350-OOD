package se.kth.iv1350.mjj.model.DTO;
import java.util.ArrayList;

public class SaleDTO {
    double runningTotal;
    double totalTax;
    ArrayList<ProductDTO> productsInSale = new ArrayList<ProductDTO>();

    SaleDTO(double runningTotal, double totalTax) {
        this.runningTotal = runningTotal;
        this.totalTax = totalTax;
    }
    public double getRunningTotal() {
        return runningTotal;
    }
    public double getTotalTax() {
        return totalTax;
    }
    public ArrayList<ProductDTO> getProductsInSale() {
        return productsInSale;
    }
}
