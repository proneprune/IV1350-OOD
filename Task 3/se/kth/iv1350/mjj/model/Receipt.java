package se.kth.iv1350.mjj.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Receipt {
    private LocalDateTime date;
    private SaleDTO finalSale;

    public Receipt(SaleDTO finalSale, double amountPaid, double change) {
        this.date = LocalDateTime.now();
        this.finalSale = finalSale;
    }

    public String getTimeOfSale() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return date.format(dateFormatter);
    }

    public SaleDTO getFinalSale() {
        return finalSale;
    }


}
