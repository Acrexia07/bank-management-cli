public class BankCustomer extends Person{

    // Constructor: Initializes Bank Customer Details
    public BankCustomer (String name, int age, String contactNumber, double balance) {
        super(name, age, contactNumber, balance);
    }

    @Override
    public void displayBankAccountInfo() {
        System.out.println("\n==== Bank Account Information ====");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.printf("Current Balance: ₱%,.2f\n", getBalance());
    }
}
