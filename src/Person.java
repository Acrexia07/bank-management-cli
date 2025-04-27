public class Person {

    // Initialization: Attributes
    public String name;
    public int age;
    public String contactNumber;
    private double balance;

    // Constructor: Initializes Person details
    Person (String name, int age, String contactNumber,double balance){
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.balance =balance;
    }

    // Setters: For Validation - balance
    public void setBalance (double balance) {
        this.balance = balance;
    }

    // Getters: For display - Encapsulated attribute
    public String getName () {
        return name;
    }

    // Getters: For display - Encapsulated attribute
    public int getAge () {
        return age;
    }

    // Getters: For display - Encapsulated attribute
    public double getBalance () {
        return balance;
    }

    // Getters: For display - Encapsulated attribute
    public String getContactNumber () {
        return contactNumber;
    }

    // Method: Displays Bank Account Information
    public void hasBankAccountInfo () {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Contact Number: " + getContactNumber());
        System.out.printf("Current Balance: ₱%,.2f\n", getBalance());
    }
}
