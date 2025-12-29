/*
 * Ashton Chavez
 * CMSC-451
 * April 8, 2025
 * 
 * Provides common benchmarking logic for all sorting algorithms.
 */

public abstract class AbstractSort {
    private long startTime;
    private long endTime;
    private int count;

    // Abstract method to be implemented by subclasses.
    public abstract void sort(int[] array) throws UnsortedException;

    // Resets the critical operation count and records start time.
    protected void startSort() {
        count = 0;
        startTime = System.nanoTime();
    }

    // Calculates the elapsed time since startSort().
    protected void endSort() {
        endTime = System.nanoTime();
    }

    // Increments the counter for the critical operation.
    protected void incrementCount() {
        count++;
    }

    // Returns the number of critical operations.
    public int getCount() {
        return count;
    }

    // Returns the time taken in nanoseconds.
    public long getTime() {
        return endTime - startTime;
    }
}