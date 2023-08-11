package binary_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordsBinarySearch {
    private static final Logger LOGGER = Logger.getLogger(WordsBinarySearch.class.getName());

    public static void main(String[] args) {
        String[] array = {"eggplant", "banana", "apple", "date", "cherry"};
        Optional<String> result = binarySearch(array, "cherry");

        if (result.isPresent()) {
            LOGGER.info("Item found!");
        } else {
            LOGGER.info("Item not found!");
        }
    }

    private static void sort(String[] array) {
        // TODO: Implement a sorting algorithm here
        Arrays.sort(array, Comparator.naturalOrder());
    }

    private static Optional<String> binarySearch(String[] array, String item) {
        sort(array);
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String guess = array[mid];

            LOGGER.log(Level.INFO, "low={0}, mid={1}, high={2}, guess={3}", new Object[]{low, mid, high, guess});

            if (guess.compareTo(item) > 0) {
                high = mid - 1;
            } else if (guess.compareTo(item) < 0) {
                low = mid + 1;
            } else {
                return Optional.of(guess);
            }
        }

        return Optional.empty();
    }
}
