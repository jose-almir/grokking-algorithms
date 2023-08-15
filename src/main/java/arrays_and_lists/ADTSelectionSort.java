package arrays_and_lists;


import binary_search.ADTBinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ADTSelectionSort {
    private record Product(String name, Double price) {
    }

    private enum Order {
        ASC, DESC
    }

    private static final Logger LOGGER = Logger.getLogger(ADTSelectionSort.class.getName());

    public static void main(String[] args) {
        Product[] products = {
                new Product("Apple", 1.0),
                new Product("Orange", 0.75),
                new Product("Banana", 0.5),
                new Product("Pineapple", 2.0),
                new Product("Watermelon", 3.0),
                new Product("Grape", 0.25),
                new Product("Strawberry", 0.10),
                new Product("Blueberry", 0.15),
                new Product("Mango", 1.50),
                new Product("Peach", 0.75)
        };

        sort(products, Comparator.comparing(Product::price), Order.DESC);
        LOGGER.log(Level.INFO, "Sorted array by price: {0}", Arrays.toString(products));

        sort(products, Comparator.comparing(Product::name), Order.ASC);
        LOGGER.log(Level.INFO, "Sorted array by name: {0}", Arrays.toString(products));

    }

    private static void sort(Product[] products, Comparator<Product> comparator, Order order) {
        for (int i = 0; i < products.length - 1; ++i) {
            int smallestIndex = i;

            for (int j = i + 1; j < products.length; ++j) { // Compare the current element with the rest of the array

                if (order == Order.ASC) {
                    if (comparator.compare(products[j], products[smallestIndex]) < 0) {
                        smallestIndex = j; // Find the smallest element
                    }
                } else {
                    if (comparator.compare(products[j], products[smallestIndex]) > 0) {
                        smallestIndex = j; // Find the smallest element
                    }
                }
            }

            // Swap the current element with the smallest element
            Product aux = products[i];
            products[i] = products[smallestIndex];
            products[smallestIndex] = aux;
        }
    }
}
