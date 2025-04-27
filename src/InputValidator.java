import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    // Initialization: Object Declaration
    static final Scanner scn = new Scanner(System.in);

    /* ------ Personal information validations ------ */

    // Method: Input validation - Name
    public static boolean validateNameInput (String name) {

        // Process: Validate name inputs if name is empty or null
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty. Please try again.");
            return false;
        }
        // Process: Validate name inputs if name has special characters
        else if (!name.matches("^[a-zA-Z\\s-]+$")) {
            System.out.println("Invalid name: Please enter a valid name containing only letters, spaces, and hyphens.");
            return false;
        }
        return true;
    }

    // Method: Input validation - Age
    public static int validateAgeInput () {

        // Initialization: Variable Declaration
        int age;

        // Process: Repeats until a valid integer between 1 and 100 is entered.
        while (true) {
            System.out.print("Enter your age: ");
            if (!scn.hasNextInt()) {
                System.out.println("Input Mismatch: Enter whole numbers only! Please try again.");
                scn.next();
            } else {
                age = scn.nextInt();
                scn.nextLine();

                // Process: Validate the age limitations
                if (age <= 0) {
                    System.out.println("Age doesn't contain negative numbers! Please try again.");
                }
                else if (age > 100) {
                    System.out.println("Invalid Age! Please try again.");
                }
                else {
                    return age;
                }
            }
        }
    }

    // Method: Input validation - Contact Number
    public static boolean validateContactNumberInput (String contactNumber ) {

        // Process: Validates contact number input
        if (contactNumber.startsWith("09")) {
            if (contactNumber.length() != 11) {
                System.out.println("Invalid contact number: Local format must be exactly 11 digits (09XXXXXXXXX)!");
                return false;
            }
        }
        else if (contactNumber.startsWith("+639")) {
            if (contactNumber.length() != 13) {
                System.out.println("Invalid contact number: International format must be exactly 13 characters (+639XXXXXXXXX)!");
                return false;
            }
        }
        else {
            System.out.println("Invalid input: Must start with '09' or '+639'! Please try again.");
            return false;
        }
        return true;
    }

    /* ------ Bank-related input validations ------ */

    // Method: Input validation - Bank menu choice
    public static char validateBankChoiceInput () {

        // Initialization: Variable Declaration
        String validateChoice;

        // Process: Loops until the user inputs correct and valid choice
        while (true) {
            System.out.print("Enter your choice: ");
            validateChoice = scn.next().toUpperCase();
            scn.nextLine();
            if (validateChoice.length() != 1 || !"ABCDEF".contains(validateChoice)) {
                System.out.println("Invalid Input: Enter correct choices (A, B, C, D, E, or F)! Please try again.");
            } else {
                return validateChoice.charAt(0);
            }
        }
    }

    // Method: Input validation - Data type (Double)
    public static double validateDeposit () {

        // Initialization: Variable Declaration
        double amount;

        // Process: Loop until the condition became false.
        while (true) {
            System.out.print("Enter an amount to be deposited: ");
            try {
                amount = scn.nextDouble();
                if (amount <= 0) {
                    System.out.println("Invalid input: Number inputs must be positive.");
                } else {
                    System.out.printf("Message: An amount of ₱%,.2f has been added to your account\n", amount);
                    System.out.println("Thank you very much! 😄\n");
                    scn.nextLine();
                    return amount;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input: Enter numbers only! Please try again.");
                scn.next();
            }
        }
    }

    // Method: Input validation - Data type (Double)
    public static double validateWithdraw (double balance) {

        // Initialization: Variable Declaration
        double amount;

        // Process: Loop until the condition became false.
        while (true) {
            System.out.print("Enter an amount to be withdrawn: ");
            try {
                amount = scn.nextDouble();
                if (amount < 0) {
                    System.out.println("Invalid input: Number inputs must be positive.");
                }
                else if (amount  > balance) {
                    System.out.println("Invalid Input: Insufficient Balance! Please try again.");
                }
                else {
                    System.out.printf("Message: An amount of ₱%,.2f has been withdrawn from your account\n", amount);
                    System.out.println("Thank you very much! 😄\n");
                    scn.nextLine();
                    return amount;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input: Enter numbers only! Please try again.");
                scn.next();
            }
        }
    }

    // Exit: Close Scanner Class
    public static void closeScanner() {
        scn.close();
    }
}
