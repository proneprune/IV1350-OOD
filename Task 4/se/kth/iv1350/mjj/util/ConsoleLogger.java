package se.kth.iv1350.mjj.util;

public class ConsoleLogger implements Logger {

    /**
     * Logs the supplied message in the console.
     * 
     * @param message The message to log in the console.
     */
    @Override
    public void log(String message) {
        System.out.println(message);
    }
    
}
