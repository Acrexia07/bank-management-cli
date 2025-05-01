public class BankTransactions {

    /* ------- Bank Transaction Related Methods ------- */

    // Method: Bank operation - Show Personal Info
    public static void displayBankAccountInfo(BankCustomer bankCustomer) {
        bankCustomer.displayBankAccountInfo();
    }

    // Method: Bank operation - Show balance
    public static void showBalance(double balance) {
        System.out.printf("Current Balance: ₱%,.2f\n", balance);
    }

    // Method: Bank operation - Deposit money
    public static double deposit () {

        // Initialization: Variable Declaration
        double amount;

        // Process: Validate user input (Double data type) - deposit
        amount = InputValidator.validateDeposit();

        return amount;
    }

    // Method: Bank operation - Withdraw balance
    public static double withdraw (double balance) {

        // Initialization: Variable Declaration
        double amount;

        // Process: Validate user input (Double data type) - withdraw
        amount = InputValidator.validateWithdraw(balance);

        return amount;
    }

    /* ------- Transaction History Related Methods ------- */

    // Method: Transaction History - Record Transactions
    public static void recordTransactions (String[] transactionHistory, String transactionType, String totalAmountBalance, double balance, double amount, int transactionCount) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = transactionType + String.format("%,.2f", amount) + totalAmountBalance + String.format("%,.2f", balance);
        }
        else {
            System.out.println("Transaction History is full!");
        }
    }

    // Method: Transaction History - Display Transactions
    public static void displayTransactions (String[] transactionHistory) {
        for (String transactions : transactionHistory) {
            if (transactions != null) {
                System.out.println(transactions);
            }
        }
    }

    /* ------- User response - Transaction Continuation ------- */

    // Method: Transaction Continuation Verification
    public static boolean transactionContinuation (Person person) {

        // Initialization: Variable Declaration
        String userResponse;

        // Loop: Asks the user if they wish to continue (Yes/No) and validates input
        // If "Yes", continue operations; if "No", thank the user and exit; otherwise, prompt again.
        while (true) {
            System.out.print("Do you wish to continue? (Yes or No): ");
            userResponse = InputValidator.scn.nextLine().trim().toLowerCase();

            if (userResponse.equals("yes")) {
                return true;
            }
            else if (userResponse.equals("no")) {
                System.out.printf("Thank you for the transactions, %s!\n", person.getName());
                System.out.println("Exiting program...\n");
                return false;
            }
            else{
                System.out.println("Invalid Input: Enter correct option (Yes or No)! Please try again");
            }
        }
    }
}
