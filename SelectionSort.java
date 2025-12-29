/*
 * Ashton Chavez
 * CMSC-451
 * April 8, 2025
 * 
 * Counts the number of comparisons (each time you compare two elements).
 * 
 * Selection Sort implementation adapted from:
 * GeeksforGeeks. "Selection Sort." https://www.geeksforgeeks.org/selection-sort/
 * Accessed April 2025.
 * Modified to integrate with AbstractSort and count comparisons.
 */

public class SelectionSort extends AbstractSort {
    @Override
    public void sort(int[] array) throws UnsortedException {
        startSort();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                incrementCount(); // comparison
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
        endSort();
        verifySorted(array);
    }

    private void verifySorted(int[] array) throws UnsortedException {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                throw new UnsortedException("Array is not sorted correctly.");
            }
        }
    }
}