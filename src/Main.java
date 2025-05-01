    public class Main {
        public static void main(String[] args) {

            //Initialization: Create a Person object by collecting user's personal information (name, age & contactNumber)
            BankCustomer bankCustomer = UserInputHandler.enterPersonalInfo();

            // Input/Outputs: Bank inputs and transactions - Overall bank operations
            BankOperations.operateBankTransactions(bankCustomer);

            // Exit: Close scanner object
            InputValidator.closeScanner();
        }
    }
