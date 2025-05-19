package se.kth.iv1350.mjj.util;

/**
 * Exceptions thrown when item with a specified prodict ID is not found
 * in the inventory system
 */
public class ItemNotFoundException extends Exception {
    /**
     * Constructs a new {@code ItemNotFoundException} with a detail message
     * indicating the specified product ID was not found in the inventory system
     *
     * @param productID the ID of the product that was not found
     */
    public ItemNotFoundException(int productID) {
        super("Item with ID " + productID + " not found in InventorySystem.");
    }
}
