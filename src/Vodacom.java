public class Vodacom extends Customer {
    // Private field as shown by '-' in UML
    private String eNumber;

    // Constructor
    public Vodacom(String cName, String oName, String mNumber, double balance, String eNumber) {
        super(cName, oName, mNumber, balance); // Calling super class constructor
        this.eNumber = eNumber;
    }

    public String getEmergencyNumber() {
        return eNumber;
    }

    // Adjusted setter to accept the new emergency number
    public void setEmergencyNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmergency Number: " + eNumber;
    }
}
