package se.kth.iv1350.mjj.startup;

import se.kth.iv1350.mjj.integration.ReceiptPrinter;
import se.kth.iv1350.mjj.integration.Display;

public class Main {
    public static void main(String[] args) {
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        Display display = new Display();
    }
}
