import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();

            if (num < 0) {
                throw new IllegalArgumentException("Square root of a negative number is not defined in real numbers.");
            }

            double result = Math.sqrt(num);
            System.out.println("Square root: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
