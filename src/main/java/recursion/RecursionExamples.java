package recursion;


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
        if(num <= 1) return 1;
        else return num * factorial(num - 1);
    }

    private static double fibonacci(double pos) {
        if(pos == 1 || pos == 2) return 1;
        else return fibonacci(pos - 1) + fibonacci(pos - 2);
    }
}
