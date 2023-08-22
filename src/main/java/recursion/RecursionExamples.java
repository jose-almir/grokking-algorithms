package recursion;


import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursionExamples {
    private static final Logger LOGGER = Logger.getLogger(RecursionExamples.class.getName());

    public static void main(String[] args) {
        double calc1 = gcd(6, 24);
        LOGGER.log(Level.INFO, "gcd(6, 24) = {0}", calc1);


        double calc2 = pow(2, 8);
        LOGGER.log(Level.INFO, "pow(2, 8) = {0}", calc2);

        double calc3 = factorial(5);
        LOGGER.log(Level.INFO, "factorial(5) = {0}", calc3);

        double calc4 = fibonacci(19);
        LOGGER.log(Level.INFO, "fibonacci(19) = {0}", calc4);

        int[] arr = new int[]{1, 2, -3, 4, 5};
        int calc5 = sum(arr);
        LOGGER.log(Level.INFO, "sum(arr) = {0}", calc5);

        int calc6 = count(arr);
        LOGGER.log(Level.INFO, "count(arr) = {0}", calc6);

        Integer calc7 = binarySearch(arr, -2);
        LOGGER.log(Level.INFO, "binarySearch(arr, -2) = {0}", calc7);
    }

    private static double pow(double a, double b) {
        if (b == 0) return 1;
        else return a * pow(a, b - 1);
    }

    private static double gcd(double a, double b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private static double factorial(double num) {
        if (num <= 1) return 1;
        else return num * factorial(num - 1);
    }

    private static double fibonacci(double pos) {
        if (pos == 1 || pos == 2) return 1;
        else return fibonacci(pos - 1) + fibonacci(pos - 2);
    }

    private static int sum(int[] arr) {
        if (arr.length == 0) return 0;
        else return arr[0] + sum(Arrays.stream(arr, 1, arr.length).toArray());
    }

    private static int count(int[] arr) {
        if (arr.length == 0) return 0;
        else return 1 + count(Arrays.stream(arr, 1, arr.length).toArray());
    }

    private static Integer binarySearch(int[] arr, int item) {
        return binarySearch(arr, item, 0, arr.length - 1);
    }

    private static Integer binarySearch(int[] arr, int item, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        int guess = arr[mid];

        if (guess == item) {
            return guess;
        } else if (guess > item) {
            return binarySearch(arr, item, low, mid - 1);
        } else {
            return binarySearch(arr, item, mid + 1, high);
        }
    }

}
