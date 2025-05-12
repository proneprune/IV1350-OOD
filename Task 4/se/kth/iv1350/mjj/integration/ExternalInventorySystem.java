package se.kth.iv1350.mjj.integration;

import se.kth.iv1350.mjj.model.DTO.ProductDTO;
import se.kth.iv1350.mjj.model.DTO.SaleDTO;
import se.kth.iv1350.mjj.util.ItemNotFoundException;

public class ExternalInventorySystem {

    private ProductDTO item1 = new ProductDTO(1, "Arboga", "Arboga 10.2%", 23.6, 0.25);
    private ProductDTO item2 = new ProductDTO(2, "Mjölk 1L", "Arla mellan mjölk 1L, 1.5% fett", 14.95, 0.12);
    private ProductDTO item3 = new ProductDTO(3, "Gräddfil Chips", "Estrella Gräddfil Chips, fett goda", 29.95, 0.12);
    private ProductDTO item4 = new ProductDTO(4, "Toalettpapper 12 pack", "Lambi toalettpaper 12 pack extra mjukt", 89.90, 0.12);


    public ExternalInventorySystem() {

    }

    /**
     * A method for returning a product based on its ID.
     * 
     * @param id The product ID of the wanted product.
     * @return A ProductDTO of the wanted product.
     */
    public ProductDTO getProductInfo(int id) throws ItemNotFoundException {
        switch (id) {
            case 1:
                return item1;
            case 2:
                return item2;
            case 3:
                return item3;
            case 4:
                return item4;
            default:
                throw new ItemNotFoundException("Item with ID " + id + " not found in InventorySystem.");
        }
    }

    /**
     * A method for updating the inventory system and stock.
     * Not fully implemented as of seminar 3, only prints in terminal.
     * 
     * @param finalSale The final SaleDTO of the sale.
     */
    public void updateInventorySystem(SaleDTO finalSale) {
        System.out.println("====================================");
        System.out.println(" Inventory system recieved SaleDTO");
        System.out.println("====================================");
    }
    
}
