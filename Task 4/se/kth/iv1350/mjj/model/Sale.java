package se.kth.iv1350.mjj.model;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;

import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;
import se.kth.iv1350.mjj.util.Cost;


public class Sale {

    private Cost cost;
    private ArrayList<Entry<ProductDTO, Integer>> productList;


    /**
     *  Creates a Sale object with an empty list of products and a price object.
     */ 
    public Sale() {
        this.cost = new Cost();
        this.productList = new ArrayList<Entry<ProductDTO, Integer>>();
    }

    /**
     * Adds a product to the sale. If the product already exists in the list, it updates the quantity.
     * 
     * @param product The product to be added to the sale.
     * @param quantity The amount of the product to be added.
     */
    public void addProduct(ProductDTO product, int quantity) {
        Entry<ProductDTO, Integer> exisitingProductEntry = getExisitingProductEntry(product);
        if (exisitingProductEntry != null) {
            exisitingProductEntry.setValue(exisitingProductEntry.getValue() + quantity);
        } else {
            Entry<ProductDTO, Integer> newProductEntry = new SimpleEntry<>(product, quantity);
            this.productList.add(newProductEntry);
        }   
        this.cost.addCost(product.getPrice(), product.getTaxRate(), quantity);
    }

    private Entry<ProductDTO, Integer> getExisitingProductEntry(ProductDTO productToCheck) {
        for (Entry<ProductDTO, Integer> entry : this.productList) {
            if (entry.getKey().getProductID() == productToCheck.getProductID()) {
                return entry;
            }
        }
        return null;
    }


    /**
     * Gets the total cost of the Sale.
     * Since VAT is included in the cost in the inventory, get total cost 
     * is the total cost including VAT.
     * 
     * @return The total cost of the sale including VAT.
     */
    public double getRunningTotalPlusVat() {
        return cost.getTotalCost();
    }

    /**
     * Get the total VAT cost of the sale.
     * 
     * @return The total VAT cost of the sale.
     */
    public double getTotalTax() {
        return cost.getTotalTaxCost();
    }

    /**
     * Returns the total theCost object.
     * 
     * @return Cost witch contains the total tax cost and total cost the pruducts added so far.
     */
    public Cost getCost() {
        return cost;
    }

    /**
     * Creates a SaleDTO object from the current sale.
     * 
     * @return A SaleDTO object containing the total cost, total tax cost, and list of products in the sale.
     */
    public SaleDTO getSaleDTO() {
        return new SaleDTO(this.cost.getTotalCost(), this.cost.getTotalTaxCost(), this.productList);
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

    /**
     * Prints the receipt for the sale using the provided ReceiptPrinter.
     * It takes in amount paid and change as well as the final saleDTO
     * @param receiptPrinter The receipt printer to be used for printing the receipt.
     * @param paymentAmount The amount paid by the customer.
     * @param change The change to be given back to the customer.
     * @param saleDTO The final saleDTO object containing the details of the sale.
     */
    public void printReceipt(ReceiptPrinter receiptPrinter, double paymentAmount, double change, SaleDTO saleDTO) {
        Receipt receipt = new Receipt(saleDTO, paymentAmount, change);
        receiptPrinter.printReceipt(receipt);
    }

}
