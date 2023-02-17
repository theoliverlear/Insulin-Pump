import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;
public class InsulinPump {
    private int carbRatio;
    private int sensitivity;
    private int bloodSugar;
    private int rangeFloor;
    ArrayList <Number> bloodSugarLog = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public InsulinPump(int carbRatio, int sensitivity, int rangeFloor, int bloodSugar ) {
        this.carbRatio = carbRatio;
        this.sensitivity = sensitivity;
        this.rangeFloor = rangeFloor;
        this.bloodSugar = bloodSugar;
    }
    public int getBloodSugar() { return this.bloodSugar; }
    public int getRangeFloor() { return this.rangeFloor; }
    public int getSensitivity() { return this.sensitivity; }
    public int getCarbRatio() { return this.carbRatio; }
    public void setCarbRatio(int amount) { this.carbRatio = amount; }
    public void setSensitivity(int amount) { this.sensitivity = amount; }
    public void deliveryScreen(double bolus) {
        for (int i = 0; i < Math.ceil(bolus) + 1; i++) {
            if (i == Math.floor(bolus)) { System.out.println("Bolus: " + bolus); } else {
                System.out.println("Bolus: " + (double) i);
                try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
        }
    }
    public void bolusWizard(int carbs) {
        double bolus = this.calculateBolus(carbs) + this.calculateCorrection();
        System.out.println("The current bolus is " + bolus + " for " + carbs + " carbs at a blood sugar level of " + this.getBloodSugar());
        deliveryScreen(bolus);
    }
    public double calculateCorrection() {
        int rangeTest = this.getBloodSugar() - this.getRangeFloor();
        if (rangeTest > 0) { return (double) rangeTest/getSensitivity(); } else { return 0; }
    }
    public double calculateBolus(int carbs) {
        return (double) carbs/this.getCarbRatio();
    }
    public void editSettings() {
        int amount;
        int choice = 0;
        boolean chosen = false;
        while (!chosen) {
            try {
                System.out.println("What setting would you like to edit?\n1. Carb Ratio\n2. Sensitivity");
                choice = Integer.parseUnsignedInt(input.next());
            } catch (NumberFormatException e) { System.err.println(e + ": Please enter an integer."); }
            switch (choice) {
                case 1:
                    try {
                        System.out.println("What do you want to set the carb ratio to be (one unit per how many carbs)?");
                        amount = Integer.parseUnsignedInt(input.next());
                        this.setCarbRatio(amount);
                        chosen = true;
                    } catch (NumberFormatException e) { System.err.println(e + ": Please enter an integer."); }
                    break;
                case 2:
                    try {
                        System.out.println("What do you want to set the sensitivity to be (one unit per how many glucose)?");
                        amount = Integer.parseUnsignedInt(input.next());
                        this.setSensitivity(amount);
                        chosen = true;
                    } catch (NumberFormatException e) { System.err.println(e + ": Please enter an integer."); }
                    break;
            }
        }
    }
    public void homeScreen() {
        boolean chosen = false;
        int choice = 0;
        menuLabel: while (!chosen){
            try {
                System.out.println("What do you want to do?\n1. Bolus Wizard\n2. Edit Settings");
                choice = Integer.parseUnsignedInt(input.next());
                chosen = true;
            } catch (NumberFormatException e) {
                System.err.println(e + ": Please enter an integer.");
            }
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Please enter the amount of carbs (if any) for the current bolus?");
                        int carbs = Integer.parseUnsignedInt(input.next());
                        bolusWizard(carbs);
                        chosen = true;
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println(e + ": Please enter an integer.");
                    }
                case 2:
                    this.editSettings();
                    chosen = true;
                    break;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the insulin pump!");
        InsulinPump pump = new InsulinPump(15, 50, 150, 300);
        pump.homeScreen();
    }
}