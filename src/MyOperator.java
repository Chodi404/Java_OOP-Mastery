import java.util.Scanner;

public class MyOperator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Register Tigo Customer");
        System.out.println("2 - Register Vodacom Customer");
        System.out.println("3 - EXIT");
        System.out.print("Select an option: ");
        int mainOption = input.nextInt();
        input.nextLine(); // Clear the buffer

        if (mainOption == 3) {
            System.out.println("Exiting... Goodbye!");
            return;
        }

        Customer customerObj = null;

        // Registration based on choice
        if (mainOption == 1) {
            System.out.println("\n--- Enter Tigo Customer Details ---");
            System.out.print("Enter Customer Name: ");
            String cName = input.nextLine();
            System.out.print("Enter Operator Name (e.g., Tigo): ");
            String oName = input.nextLine();
            System.out.print("Enter Mobile Number: ");
            String mNumber = input.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = input.nextDouble();
            System.out.print("Enter PIN (4 digits): ");
            int pin = input.nextInt();

            // Instantiate Tigo object
            customerObj = new Tigo(cName, oName, mNumber, balance, pin);

        } else if (mainOption == 2) {
            System.out.println("\n--- Enter Vodacom Customer Details ---");
            System.out.print("Enter Customer Name: ");
            String cName = input.nextLine();
            System.out.print("Enter Operator Name (e.g., Vodacom): ");
            String oName = input.nextLine();
            System.out.print("Enter Mobile Number: ");
            String mNumber = input.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = input.nextDouble();
            input.nextLine(); // Clear buffer
            System.out.print("Enter Emergency Number: ");
            String eNumber = input.nextLine();

            // Instantiate Vodacom object
            customerObj = new Vodacom(cName, oName, mNumber, balance, eNumber);
        } else {
            System.out.println("Invalid Option! Program terminated.");
            return;
        }

        // Display sub-menus based on Object Type using 'instanceof'
        System.out.println("1 – Display My Mobile Operator Details");
        System.out.println("2 – Display Current Balance");
        System.out.println("3 – Deposit Money");
        System.out.println("4 – Withdraw Money");

        if (customerObj instanceof Tigo) {
            System.out.println("5 – Change Pin");
        } else if (customerObj instanceof Vodacom) {
            System.out.println("5 – Change Emergency Number");
        }

        System.out.print("Select an option: ");
        int subOption = input.nextInt();
        input.nextLine(); // Clear buffer

        // Processing operations
        switch (subOption) {
            case 1:
                System.out.println("\n--- Account Details ---");
                System.out.println(customerObj.toString());
                break;

            case 2:
                System.out.println("\nCurrent Account Balance: " + customerObj.getBalance() + " TZS");
                break;

            case 3:
                System.out.print("\nEnter amount to deposit: ");
                double depAmount = input.nextDouble();
                customerObj.deposit(depAmount);
                System.out.println("Deposit transaction completed successfully.");
                break;

            case 4:
                System.out.print("\nEnter amount to withdraw: ");
                double withAmount = input.nextDouble();
                customerObj.withdraw(withAmount); // Logic validation inside the method
                break;

            case 5:
                if (customerObj instanceof Tigo) {
                    System.out.print("\nEnter new PIN number: ");
                    int newPin = input.nextInt();
                    ((Tigo) customerObj).setPin(newPin); // Downcasting to access child method
                    System.out.println("The pin changed successfully.");
                } else if (customerObj instanceof Vodacom) {
                    System.out.print("\nEnter new emergency number: ");
                    String newENumber = input.nextLine();
                    ((Vodacom) customerObj).setEmergencyNumber(newENumber); // Downcasting
                    System.out.println("The emergency number changed successfully.");
                }
                break;

            default:
                System.out.println("Invalid Sub-Option!");
                break;
        }

        System.out.println("\nProgram ends. Thank you!");
        input.close();
    }
}