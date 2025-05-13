package se.kth.iv1350.mjj.util;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(int productID) {
        super("Item with ID " + productID + " not found in InventorySystem.");
    }
}
