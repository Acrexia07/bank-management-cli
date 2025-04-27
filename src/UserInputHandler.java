public class UserInputHandler {

    // Method: Personal Information
    public static Person enterPersonalInfo () {

        // Initialization: Variable Declaration
        String name;
        int age;
        String contactNumber;

        System.out.println("---- Welcome to the ABC Bank ----\n");
        // Process: User input handler - Name
        do {
            System.out.print("Enter your name: ");
            name = InputValidator.scn.nextLine();
        } while (!InputValidator.validateNameInput(name));

        // Process: User input handler - Age
        age = InputValidator.validateAgeInput();

        // Process: User input handler - Contact Number
        do {
            System.out.print("Enter your contact number (PH Format start with '09' or '+639'): ");
            contactNumber = InputValidator.scn.nextLine();
        } while (!InputValidator.validateContactNumberInput(contactNumber));

        // Process: User input handler - Creates a return Person object with name, age and contactNumber
        return new Person(name, age, contactNumber, 0);
    }
}
