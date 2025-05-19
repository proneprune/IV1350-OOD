package se.kth.iv1350.mjj.util;

/**
 *  Exceptions thrown when database is unreachable for example due to network errors.
 */
public class DatabaseUnreachableException extends Exception {
    /**
     * Constructs a new {@code DatabaseUnreachableException} with a detail message
     * indicating why the database was unreachable.
     *
     * @param message the detailed message explaining why the database is unreachable
     */
    public DatabaseUnreachableException(String message) {
        super(message);
    }
}
