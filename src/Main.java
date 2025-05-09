public class Main {
    public static void main(String[] args) {

        // Initialization: Factory Initialization
        PersonFactory personFactory = new BankCustomerFactory();

        //Initialization: Create a Person object by collecting user's personal information (name, age & contactNumber)
        Person bankCustomer = UserInputHandler.enterPersonalInfo(personFactory);

        // Input/Outputs: Bank inputs and transactions - Overall bank operations
        BankOperations.operateBankTransactions ((BankCustomer) bankCustomer);

        // Exit: Close scanner object
        InputValidator.closeScanner();
    }
}
