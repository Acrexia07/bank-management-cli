public class BankCustomerFactory extends PersonFactory{

    // Method: Overridden abstract class
    @Override
    public Person createPerson (String name, int age, String contactNumber, double balance) {
        return new BankCustomer(name, age, contactNumber, balance);
    }
}
