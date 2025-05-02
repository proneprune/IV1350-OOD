package se.kth.iv1350.mjj.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Receipt {
    private LocalDateTime dateAndTime;
    private SaleDTO finalSale;
    private double amountPaid;
    private double change;

    Receipt(SaleDTO finalSale, double amountPaid, double change) {
        this.dateAndTime = LocalDateTime.now();
        this.finalSale = finalSale;
        this.amountPaid = amountPaid;
        this.change = change;
    }

    public String getTimeOfSale() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateAndTime.format(dateFormatter);
    }

    public SaleDTO getFinalSale() {
        return finalSale;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getChange() {
        return change;
    }

}
