package binary_search;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicBinarySearch {
    private static final Logger LOGGER = Logger.getLogger(BasicBinarySearch.class.getName());

    public static void main(String[] args) {
        Integer[] array = {1, 3, 5, 7, 9};
        Optional<Integer> result = binarySearch(array, 1);

        if (result.isPresent()) {
            LOGGER.info("Item found!");
        } else {
            LOGGER.info("Item not found!");
        }
    }

    private static Optional<Integer> binarySearch(Integer[] array, int item) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];

            LOGGER.log(Level.INFO, "low={0}, mid={1}, high={2}, guess={3}", new Object[]{low, mid, high, guess});

            if (guess > item) {
                high = mid - 1;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                return Optional.of(guess);
            }
        }

        return Optional.empty();
    }
}