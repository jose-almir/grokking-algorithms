package binary_search;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ADTBinarySearch {

    private record Person(String name, String email, LocalDate birthdate) implements Comparable<Person> {
        @Override
        public int compareTo(Person person) {
            return name.compareToIgnoreCase(person.name);
        }
    }

    private static final Logger LOGGER = Logger.getLogger(ADTBinarySearch.class.getName());

    public static void main(String[] args) {
        Person[] people = {
                new Person("John Doe", "johndoe@email.com", LocalDate.of(1985, 5, 15)),
                new Person("Jane Smith", "janesmith@email.com", LocalDate.of(1990, 9, 22)),
                new Person("Michael Johnson", "michaeljohnson@email.com", LocalDate.of(1982, 3, 8)),
                new Person("Emily Brown", "emilybrown@email.com", LocalDate.of(1995, 12, 3)),
                new Person("William Wilson", "williamwilson@email.com", LocalDate.of(1988, 7, 18)),
                new Person("Olivia Martinez", "oliviamartinez@email.com", LocalDate.of(1993, 2, 10)),
                new Person("Daniel Taylor", "danieltaylor@email.com", LocalDate.of(1997, 6, 27)),
                new Person("Sophia Anderson", "sophiaanderson@email.com", LocalDate.of(1994, 11, 14)),
                new Person("James Lee", "jameslee@email.com", LocalDate.of(1987, 4, 9)),
                new Person("Ava Jackson", "avajackson@email.com", LocalDate.of(1996, 8, 31))
        };

        Optional<Person> result = binarySearch(people, "William Wilson");

        if (result.isPresent()) {
            LOGGER.info("Item found!");
        } else {
            LOGGER.info("Item not found!");
        }
    }

    private static void sort(Person[] people) {
        // TODO: Implement a sorting algorithm here
        Arrays.sort(people, Comparator.naturalOrder());
    }


    private static Optional<Person> binarySearch(Person[] people, String name) {
        sort(people);
        int low = 0;
        int high = people.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Person guess = people[mid];

            LOGGER.log(Level.INFO, "low={0}, mid={1}, high={2}, guess={3}", new Object[]{low, mid, high, guess});


            if (guess.name.compareToIgnoreCase(name) > 0) {
                high = mid - 1;
            } else if (guess.name.compareToIgnoreCase(name) < 0) {
                low = mid + 1;
            } else {
                return Optional.of(guess);
            }
        }

        return Optional.empty();
    }
}
