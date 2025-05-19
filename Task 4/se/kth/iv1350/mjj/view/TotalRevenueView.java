package se.kth.iv1350.mjj.view;

import se.kth.iv1350.mjj.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    
    private double totalRevenue;

    /**
     * Updates the total revenue displayed in the view.
     * 
     * @param revenue The revenue to be added to the total revenue.
     */
    @Override
    public void updateRevenue(double revenue) { 
        this.totalRevenue += revenue;
        displayTotalRevenue();
    }

    /**
     * Displays the total revenue.
     */
    private void displayTotalRevenue() {
        System.out.println("----------------------Revenue Report----------------------");
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("----------------------------------------------------------");
    }
    
}
