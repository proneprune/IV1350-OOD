package se.kth.iv1350.mjj.controller;

import se.kth.iv1350.mjj.integration.Display;
import se.kth.iv1350.mjj.integration.ExternalAccountingSystem;
import se.kth.iv1350.mjj.integration.ExternalInventorySystem;
import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.model.CashRegister;
import se.kth.iv1350.mjj.model.Sale;
import se.kth.iv1350.mjj.model.DTO.ProductDTO;

public class SaleController {
    private Sale sale;
    private ExternalInventorySystem inventorySystem;
    private ExternalAccountingSystem accountingSystem;
    //discount db
    private ReceiptPrinter receiptPrinter;
    private Display display;
    private CashRegister cashRegister;


    public SaleController(ExternalAccountingSystem accountingSystem, ExternalInventorySystem inventorySystem, 
                                    ReceiptPrinter receiptPrinter, Display display, CashRegister cashRegister) {
        this.accountingSystem = accountingSystem;
        this.inventorySystem = inventorySystem;
        this.receiptPrinter = receiptPrinter;
        this.display = display;
        this.cashRegister = cashRegister;
    }

    public void startSale(){
        this.sale = new Sale();
    }


    //this method will now retrieve from the inventory even if a product 
    //with that id aldready exists in the sale.
    //Can be changed to check if the product exists in the sale and then just
    //update the quantity instead of retrieving it again. TBC
    public void scanProduct(int productID, int quantity){
        ProductDTO product = getProduct(productID);
        sale.addProduct(product, quantity);
    }

    private ProductDTO getProduct(int productID){
        return inventorySystem.getProduct(productID);
    }

    public double endSale(){

        return 0;
    }

    public void getDiscount(int customerID){

    }

    public double enterAmount(double paymentAmount){
        return 0;
    }

}
