package se.kth.iv1350.mjj.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.mjj.model.RevenueObserver;

public class TotalRevenueFileOutput implements RevenueObserver {
    
    private PrintWriter logStream;

    private double totalRevenue;

    /**
     * Updates the total revenue to be logged.
     * 
     * @param revenue The revenue to be added to the total revenue.
     */
    @Override
    public void updateRevenue(double revenue) { 
        totalRevenue += revenue;
        logRevenue(totalRevenue);
    }

    /**
     * Creates a new instance and flushes exisiting revenue log file, to start from blank.
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("revenueLog.txt"), true);
        } catch (IOException e) {
            System.out.println("Not able to log.");
            e.printStackTrace();
        }
    }

    /**
     * Logs the supplied revenue in the revenue log file.
     * 
     * @param revenue The message to log.
     */
    public void logRevenue(double revenue) {
        logStream.printf("New Total Revenue: %.2f", revenue);
    }
    
}
