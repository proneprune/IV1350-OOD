package se.kth.iv1350.mjj.model;

import java.time.LocalDateTime;

import se.kth.iv1350.mjj.model.DTO.SaleDTO;

public class Receipt {
    private LocalDateTime date;
    private int hour;
    private int minute;

    public Receipt(SaleDTO finalSale, double amountPaid, double change) {
        setDateTime();

    }

    private void setDateTime() {
        this.date = LocalDateTime.now();
        this.hour = date.getHour();
        this.minute = date.getMinute();
    }
}
