public class BankOperations {

    // Initialization: Object Declaration
    static BankCustomer bankCustomer;

    // Initialization: Array Declaration
    private final static String[] bankOptions = {"A. Show Personal Info",
                                                 "B. Check Balance",
                                                 "C. Deposit Money",
                                                 "D. Withdraw Money",
                                                 "E. Show Transaction History",
                                                 "F. Exit"};

    //Initialization: For Array to store transaction history
    private static final String[] transactionHistory = new String[10];
    private static int transactionCount  = 0;

    // Method: Bank Operations - Operate bank transactions
    public static void operateBankTransactions (BankCustomer bankCustomer) {

        // Initialization: Set the static person field
        BankOperations.bankCustomer = bankCustomer;

        // Initialization: Variable Declaration
        char choice;
        double balance = bankCustomer.getBalance();
        boolean isRunning = true;

        while (isRunning) {
            //Initialization: Display welcome message and bank menu
            displayBankMenu(bankOptions);

            // Process: Validates if the choice inputted correctly and valid
            choice = InputValidator.validateBankChoiceInput();

            switch (choice) {
                case 'A' -> {
                    BankTransactions.displayBankAccountInfo(bankCustomer);
                    System.out.println("-----------------------------\n");

                    // Process: Verify if the user wants to continue his/her transaction
                    isRunning = BankTransactions.transactionContinuation(bankCustomer);
                }
                case 'B' -> {
                    System.out.println("\n==== Display Balance ====");
                    BankTransactions.showBalance(balance);
                    System.out.println("-----------------------------\n");

                    // Process: Verify if the user wants to continue his/her transaction
                    isRunning = BankTransactions.transactionContinuation(bankCustomer);
                }
                case 'C' -> {
                    System.out.println("\n==== Deposit Money ====");
                    double amount = BankTransactions.deposit();
                    balance += amount;
                    bankCustomer.setBalance(balance);

                    // Process: Record transaction and update transaction count
                    BankTransactions.recordTransactions(transactionHistory, "Transaction: Deposited an amount of ₱"," *** Updated Balance: ₱", balance, amount, transactionCount);
                    transactionCount++;

                    BankTransactions.showBalance(balance);
                    System.out.println("-----------------------------\n");

                    // Process: Verify if the user wants to continue his/her transaction
                    isRunning = BankTransactions.transactionContinuation(bankCustomer);
                }
                case 'D' -> {
                    System.out.println("\n==== Withdraw Balance ====");
                    double amount = BankTransactions.withdraw(balance);
                    balance -= amount;
                    bankCustomer.setBalance(balance);

                    // Process: Record transaction and update transaction count
                    BankTransactions.recordTransactions(transactionHistory, "Transaction: Withdrawn an amount of ₱"," *** Updated Balance: ₱", balance,  amount, transactionCount);
                    transactionCount++;

                    BankTransactions.showBalance(balance);
                    System.out.println("-----------------------------\n");

                    // Process: Verify if the user wants to continue his/her transaction
                    isRunning = BankTransactions.transactionContinuation(bankCustomer);
                }
                case 'E' -> {
                    System.out.println("\n==== Show Transaction History ====\n");
                    System.out.println("Transaction Logs:");
                    BankTransactions.displayTransactions(transactionHistory);
                    System.out.println("-----------------------------\n");

                    // Process: Verify if the user wants to continue his/her transaction
                    isRunning = BankTransactions.transactionContinuation(bankCustomer);
                }
                case 'F' -> {
                    System.out.printf("Thank you for the transactions, %s!\n", bankCustomer.getName());
                    System.out.println("Exiting program...");
                    isRunning = false;
                }
                default -> System.out.println("Invalid Input: Enter correct choices (A, B, C, D, E, or F)! Please try again.");
            }
        }
    }

    //Method: Bank Operations - Display Bank Menu
    public static void displayBankMenu(String... bankOptions) {
        System.out.printf("\nWelcome to the bank, %s!\n", bankCustomer.getName());
        for(String option : bankOptions){
            System.out.println(option);
        }
    }
}
