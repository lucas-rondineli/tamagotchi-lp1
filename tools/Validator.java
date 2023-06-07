package tools;

import java.io.InputStream;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * The {@code Validator} class facilitates user input by using the Scanner class
 * and ensuring that its methods return the required input.
 */
public class Validator {
    private Scanner sc;
    private boolean closed = false;

    /**
     * Constructs a new {@code Validator} instance that reads values from the
     * specified input stream using the {@code Scanner} class.
     * 
     * @param source An input stream to be scanned.
     */
    public Validator(InputStream source) {
        sc = new Scanner(source);
    }

    /**
     * Closes the Scanner used by this class.
     * 
     * @return {@code true} if the {@code Scanner} was successfully closed,
     *         {@code false} otherwise.
     */
    public boolean close() {
        if (closed)
            return false;
        sc.close();
        closed = true;
        return true;
    }

    /**
     * Validates the user input to ensure it returns an Integer that meets the
     * specified requirements.
     * 
     * @param msg  A String to be displayed to the user.
     * @param err  A String to be displayed to the user if the input does not meet
     *             the required conditions.
     * @param test A Predicate that takes an Integer as input and returns a boolean
     *             value.
     * @return An Integer that satisfies the conditions specified by the Predicate.
     * @throws IllegalStateException if this instance's Scanner is closed.
     */
    public int validateInt(String msg, String err, Predicate<Integer> test) {
        if (closed)
            throw new IllegalStateException("This class Scanner was already closed.");

        int aux = 0;
        while (true)
            try {
                System.out.printf(msg);
                aux = sc.nextInt();
                if (test.test(aux))
                    break;
                throw new Exception();
            } catch (Exception e) {
                System.out.printf(err);
                sc.nextLine();
            }
        sc.nextLine();
        return aux;
    }

    /**
     * Validates the user input to ensure it returns a double that meets the
     * specified requirements.
     * 
     * @param msg  A String to be displayed to the user.
     * @param err  A String to be displayed to the user if the input does not meet
     *             the required conditions.
     * @param test A Predicate that takes a Double as input and returns a boolean
     *             value.
     * @return A Double that satisfies the conditions specified by the Predicate.
     * @throws IllegalStateException if this instance's Scanner is closed.
     */
    public double validateDouble(String msg, String err, Predicate<Double> test) {
        if (closed)
            throw new IllegalStateException("This class Scanner was already closed.");

        double aux = 0;
        while (true)
            try {
                System.out.printf(msg);
                aux = sc.nextDouble();
                if (test.test(aux))
                    break;
                throw new Exception();
            } catch (Exception e) {
                System.out.printf(err);
                sc.nextLine();
            }
        sc.nextLine();
        return aux;
    }

    /**
     * Validates the user input to ensure it returns a String that meets the
     * specified requirements.
     * 
     * @param msg  A String to be displayed to the user.
     * @param err  A String to be displayed to the user if the input does not meet
     *             the required conditions.
     * @param test A Predicate that takes a String as input and returns a boolean
     *             value.
     * @return A String that satisfies the conditions specified by the Predicate.
     * @throws IllegalStateException if this instance's Scanner is closed.
     */
    public String validateString(String msg, String err, Predicate<String> test) {
        if (closed)
            throw new IllegalStateException("This class Scanner was already closed.");

        String aux = "";
        while (true)
            try {
                System.out.printf(msg);
                aux = sc.nextLine().strip();
                if (test.test(aux))
                    break;
                throw new Exception();
            } catch (Exception e) {
                System.out.printf(err);
            }
        return aux;
    }
}
