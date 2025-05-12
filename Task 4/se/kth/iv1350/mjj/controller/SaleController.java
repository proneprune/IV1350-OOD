package se.kth.iv1350.mjj.controller;

import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.integration.ExternalAccountingSystem;
import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.model.CashRegister;
import se.kth.iv1350.mjj.model.Sale;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;


public class SaleController {
    private Sale sale;
    private ExternalInventorySystem inventorySystem;
    private ExternalAccountingSystem accountingSystem;
    //discount db
    private ReceiptPrinter receiptPrinter;
    private Display display;
    private CashRegister cashRegister;
    private SaleDTO finalSaleDTO;

    /**
     * Creates a sale controller initiated with with all the external systems.
     * 
     * @param accountingSystem The external accounting system to be used.
     * @param inventorySystem The external inventory system to be used.
     * @param receiptPrinter The receipt printer connected to this sale
     * @param display   The display connected to this sale
     * @param cashRegister The cash register connected to this sale
     */
    public SaleController(ExternalAccountingSystem accountingSystem, ExternalInventorySystem inventorySystem, 
                                    ReceiptPrinter receiptPrinter, Display display) {
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.receiptPrinter = receiptPrinter;
        this.display = display;
        this.cashRegister = new CashRegister();
    }
    
    /**
     * Starts a new sale by creating a sale object.
     */
    public void startSale(){
        this.sale = new Sale();
    }


    //this method will now retrieve from the inventory even if a product 
    //with that id aldready exists in the sale.
    //Can be changed to check if the product exists in the sale and then just
    //update the quantity instead of retrieving it again. TBC

    /**
     * Scans a product with a given product ID and quantity
     * Uses the private method getProduct to retrieve the product from the inventory system.
     *  
     * @param productID the ID of the product that is scanned
     * @param quantity the amount of the product that is scanned
     */
    public void scanProduct(int productID, int quantity){
        ProductDTO product = getProduct(productID);
        if(product != null) {
            sale.addProduct(product, quantity);
            display.updateDisplay(product, quantity, sale.getCost());
        } 
    }

    private ProductDTO getProduct(int productID){
        
        return inventorySystem.getProductInfo(productID);
    }

    /**
     * Ends the sale and returns the total amount to be paid.
     * Creates a finalized SaleDTO object with the current sale information.
     * 
     * @return The total amount to be paid for the sale.
     */

    public double endSale(){
        finalSaleDTO = sale.getSaleDTO();

        return sale.getRunningTotalPlusVat();
    }

    /**
     *  A method to get a discount for a customer.
     *  This method is not implemented in sem3
     * 
     * @param customerID The ID of the customer to get a discount for.
     */
    public void getDiscount(int customerID){
        //will apply discount eventually
    }

    /**
     * This method is used to call the cash register to calculate the change to be given back to the customer.
     * It also updates inventory and accounting systems, and prints the receipt.
     * 
     * In case of negative or insufficent payment, -1 and -2 is returned respectively. 
     * This will be updated for sem 4 with exceptions.
     * 
     * The updating of the external systems is not implemented as of sem 3.
     * 
     * @param paymentAmount The amount paid by the customer.
     * @return The change to be given back to the customer.
     */
    public double enterAmount(double paymentAmount){
        double change = 0;
        if (paymentAmount < 0) {
            return -1;
        } else if (paymentAmount < finalSaleDTO.getRunningTotal()) {
            return -2;
        }
        change = cashRegister.calculateChange(paymentAmount, finalSaleDTO);
        inventorySystem.updateInventorySystem(finalSaleDTO);
        accountingSystem.updateAccountingSystem(finalSaleDTO);
        sale.printReceipt(receiptPrinter, paymentAmount, change, finalSaleDTO);

        return change;
    }
}
