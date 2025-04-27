    public class Main {
        public static void main(String[] args) {

            //Initialization: Create a Person object by collecting user's personal information (name, age & contactNumber)
            Person person = UserInputHandler.enterPersonalInfo();

            // Input/Outputs: Bank inputs and transactions
            BankOperations.operateBankTransactions(person);

            // Exit: Close scanner object
            InputValidator.closeScanner();
        }
    }
