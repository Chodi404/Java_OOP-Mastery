public class Tigo extends Customer {
    // Private field as shown by '-' in UML
    private int pin;

    // Constructor
    public Tigo(String cName, String oName, String mNumber, double balance, int pin) {
        super(cName, oName, mNumber, balance); // Calling super class constructor
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPIN: " + pin;
    }
}