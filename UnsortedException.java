/*
 * Ashton Chavez
 * CMSC-451
 * April 8, 2025
 * 
 * Thrown if a sorting algorithm fails to sort the array correctly.
 */

public class UnsortedException extends Exception {
    public UnsortedException(String message) {
        super(message);
    }
}