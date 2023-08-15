package arrays_and_lists;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectionSort {
    private static final Logger LOGGER = Logger.getLogger(SelectionSort.class.getName());


    public static void main(String[] args) {
        int[] arr = {100, 200, 3, -1, 5, 0, 4};
        selectionSort(arr);

        LOGGER.log(Level.INFO, "Sorted array: {0}", Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        // Selection Sort will sort the array in-place
        // It will find the smallest element in the array and swap it with the first element
        // Then it will find the second-smallest element and swap it with the second element
        // And so on...
        for (int i = 0; i < arr.length - 1; ++i) {
            int smallestIndex = i;

            for (int j = i + 1; j < arr.length; ++j) { // Compare the current element with the rest of the array
                if (arr[j] < arr[smallestIndex]) {
                    smallestIndex = j; // Find the smallest element
                }
            }

            // Swap the current element with the smallest element
            int aux = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = aux;
        }
    }
}
