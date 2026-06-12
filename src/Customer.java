public class Customer {
    // Protected fields
    protected String oName; // Operator Name
    protected String cName; // Customer Name
    protected String mNumber; // Mobile Number
    protected double balance;

    // Constructor
    public Customer(String cName, String oName, String mNumber, double balance) {
        this.cName = cName;
        this.oName = oName;
        this.mNumber = mNumber;
        this.balance = balance;
    }

    // Getters
    public String getOperatorName() {
        return oName;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getMobileNumber() {
        return mNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdraw transaction completed successfully."); // Req requirement
        } else {
            System.out.println("Sorry, You have insufficient account balance."); // Req requirement
        }
    }

    @Override
    public String toString() {
        return "Customer Name: " + cName +
                "\nOperator Name: " + oName +
                "\nMobile Number: " + mNumber +
                "\nBalance: " + balance;
    }
}