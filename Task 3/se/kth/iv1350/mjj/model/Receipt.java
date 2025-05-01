package se.kth.iv1350.mjj.model;

import java.time.LocalDateTime;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Receipt {
    private LocalDateTime date;
    private SaleDTO finalSale;

    public Receipt(SaleDTO finalSale, double amountPaid, double change) {
        this.date = LocalDateTime.now();
        this.finalSale = finalSale;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public SaleDTO getFinalSale() {
        return finalSale;
    }


}
