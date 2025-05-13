package se.kth.iv1350.mjj.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Receipt {
    private LocalDateTime dateAndTime;
    private SaleDTO finalSale;
    private double amountPaid;
    private double change;

    /**
     * Creates a new instance of Receipt.
     * @param finalSale The sale that the receipt is based on.
     * @param amountPaid The amount paid by the customer.
     * @param change The change to be returned to the customer.
     */

    Receipt(SaleDTO finalSale, double amountPaid, double change) {
        this.dateAndTime = LocalDateTime.now();
        this.finalSale = finalSale;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    /**
     * Getter for the date and time of the sale.
     * @return The date and time of the sale in the format "yyyy-MM-dd HH:mm".
     */
    public String getTimeOfSale() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateAndTime.format(dateFormatter);
    }

    /**
     * Getter for the final sale.
     * @return The final sale.
     */
    public SaleDTO getFinalSale() {
        return finalSale;
    }

    /**
     * Getter for the amount paid by the customer.
     * @return The amount paid by the customer.
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Getter for the change to be returned to the customer.
     * @return The change to be returned to the customer.
     */
    public double getChange() {
        return change;
    }

}
