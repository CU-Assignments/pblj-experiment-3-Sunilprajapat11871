import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATM {
    private static final int PIN = 1871; // Set PIN for testing
    private static double balance = 50000.0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin != PIN) {
                throw new InvalidPINException("Incorrect PIN. Access denied.");
            }

            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! You withdrew: ₹" + amount);

        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid numeric values.");
        } finally {
            System.out.println("Remaining balance: ₹" + balance);
            scanner.close();
        }
    }
}
