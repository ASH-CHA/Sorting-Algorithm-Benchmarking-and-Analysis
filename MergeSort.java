/*
 * Ashton Chavez
 * CMSC-451
 * April 8, 2025
 * 
 * Counts the number of array element copies during the merging phase 
 * (each time an element is written into the temporary array or back into the original array).
 * 
 * Merge Sort implementation adapted from:
 * GeeksforGeeks. "Merge Sort." https://www.geeksforgeeks.org/merge-sort/
 * Accessed April 2025.
 * Minor modifications made to integrate with AbstractSort for benchmarking.
 */

public class MergeSort extends AbstractSort {
    @Override
    public void sort(int[] array) throws UnsortedException {
        startSort();
        mergeSort(array, 0, array.length - 1);
        endSort();
        verifySorted(array);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            incrementCount(); // comparison during merge
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (k = 0; k < temp.length; k++) {
            array[left + k] = temp[k];
        }
    }

    private void verifySorted(int[] array) throws UnsortedException {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                throw new UnsortedException("Array is not sorted correctly.");
            }
        }
    }
}