package arrays_and_lists;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Array {
    private static final Logger LOGGER = Logger.getLogger(Array.class.getName());

    public static void main(String[] args) {
        // Arrays are a random access structure. That means that we can access any element in the
        // array in constant time O(1). This is because arrays are stored in contiguous memory locations.
        // There's no need to traverse the array to find the element we want to access.
        // The downside of arrays is that they have a fixed size. Once we create an array, we can't
        // change its size. If we want to add or remove elements, we have to create a new array.
        // Operations involving arrays:
        //  - Accessing an element: O(1)
        //  - Searching for an element (linear): O(n)
        //  - Inserting an element: O(n)
        //  - Deleting an element: O(n)
        //  - Copying an array: O(n)
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr2 = append(arr, 7);
        int[] arr3 = insertAt(arr2, 1000, 1);
        int[] arr4 = insertAt(arr3, 500, 0);
        int[] arr5 = pop(arr4);
        int[] arr6 = removeAt(arr5, 2);

        LOGGER.log(Level.INFO, "Element at the index O(1): {0}", getElement(arr, 3));
        LOGGER.log(Level.INFO, "Found on linear search O(n): {0}", linearSearch(arr, 7));
        LOGGER.log(Level.INFO, "Found on binary search O(log n): {0}", binarySearch(arr, 7));
        LOGGER.log(Level.INFO, "New array with element inserted at the end O(n): {0}", Arrays.toString(arr2));
        LOGGER.log(Level.INFO, "New array with element inserted at a defined position O(n): {0}", Arrays.toString(arr3));
        LOGGER.log(Level.INFO, "New array with element inserted at a defined position O(n): {0}", Arrays.toString(arr4));
        LOGGER.log(Level.INFO, "New array with element removed at the end O(n): {0}", Arrays.toString(arr5));
        LOGGER.log(Level.INFO, "New array with element removed at a defined position O(n): {0}", Arrays.toString(arr6));
    }

    private static int getElement(int[] arr, int index) {
        return arr[index];
    }

    private static boolean linearSearch(int[] arr, int element) {
        for (int j : arr) {
            if (j == element) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int element) {
        return Arrays.binarySearch(arr, element) > -1;
    }

    private static int[] append(int[] arr, int element) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = element;

        return newArr;
    }

    private static int[] insertAt(int[] arr, int element, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);

        newArr[index] = element;


        for (int i = index + 1; i < newArr.length; ++i) {
            newArr[i] = arr[i - 1];
        }

        return newArr;
    }

    private static int[] pop(int[] arr) {
        return Arrays.copyOf(arr, arr.length - 1);
    }

    private static int[] removeAt(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        int[] newArr = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            newArr[j++] = arr[i];
        }

        return newArr;
    }
}
