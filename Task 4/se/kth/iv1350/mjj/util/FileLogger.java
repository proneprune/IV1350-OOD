package se.kth.iv1350.mjj.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    private PrintWriter logStream;

    /**
     * Creates a new instance and flushes exisiting error log file, replacing with a new file.
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("errorLog.txt"), true);
        } catch (IOException e) {
            System.out.println("Not able to log.");
            e.printStackTrace();
        }
    }

    /**
     * Logs the supplied message in a file.
     * 
     * @param message The message to log.
     */
    @Override
    public void log(String message) {
        logStream.println(message);
    }
    
}
