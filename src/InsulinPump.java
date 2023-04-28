// Oliver Sigwarth
// A Java program for diabetics that makes calculations that help manage their blood sugar.
// Created 2/16/2023
// Last Modified 2/16/2023
import java.util.*;
import java.text.SimpleDateFormat;
public class InsulinPump {
    private int carbRatio;
    private int sensitivity;
    private int bloodSugar;
    private int rangeFloor;
    private double reservoir;
    private double insulinRemaining;
    private double basalRatePerHour;
    ArrayList <Integer> bloodSugarLog = new ArrayList<>();
    TreeMap<Integer, Date> bloodSugarTimeLog = new TreeMap<Integer, Date>();
    static Scanner input = new Scanner(System.in);
    SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss aaa");
    public InsulinPump(int carbRatio, int sensitivity, int rangeFloor, int bloodSugar, double basalRatePerHour) {
        this.carbRatio = carbRatio;
        this.sensitivity = sensitivity;
        this.rangeFloor = rangeFloor;
        this.bloodSugar = bloodSugar;
        this.basalRatePerHour = basalRatePerHour;
    }
    public int getBloodSugar() { return this.bloodSugar; }
    public int getRangeFloor() { return this.rangeFloor; }
    public int getSensitivity() { return this.sensitivity; }
    public int getCarbRatio() { return this.carbRatio; }
    public double getBasalRatePerHour() { return this.basalRatePerHour; }
    public void setBloodSugar(int amount) { this.bloodSugar = amount; }
    public void setCarbRatio(int amount) { this.carbRatio = amount; }
    public void setSensitivity(int amount) { this.sensitivity = amount; }
    public void deliveryScreen(double bolus) {
        for (int i = 0; i < Math.ceil(bolus) + 1; i++) {
            if (i == Math.ceil(bolus)) { System.out.println("Bolus: " + bolus); break; } else {
                System.out.println("Bolus: " + (double) i);
                try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
            }
        }
    }
    public double calculateBasal(double hours) {
        return hours * this.getBasalRatePerHour();
    }
    public void testBloodSugar() {
        System.out.println("What is your blood sugar?");
        int bloodSugarTest = input.nextInt();
        this.setBloodSugar(bloodSugarTest);
        addToBloodSugarHistory(bloodSugarTest);
    }
    public void addToBloodSugarHistory(int bloodSugar) {
        bloodSugarLog.add(bloodSugar);
        bloodSugarTimeLog.put(getBloodSugar(), new Date());
    }
    public void viewHistory() { // To do: different history methods
        for (Map.Entry<Integer, Date> entry : bloodSugarTimeLog.entrySet()) {
            System.out.println("Time: " +  dateTimeFormatter.format(entry.getValue()) + " Blood sugar: " + entry.getKey() + "mg/dl");
        }
    }
    public void bolusWizard(int carbs) {
        double bolus = this.calculateBolus(carbs) + this.calculateCorrection();
        System.out.println("The current bolus is " + bolus + " for " + carbs + " carbs at a blood sugar level of " + this.getBloodSugar());
        deliveryScreen(bolus);
    }
    public double calculateLantus() {
        return basalRatePerHour * 8;
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
                choice = Integer.parseInt(input.next());
            } catch (NumberFormatException e) { System.err.println(e + ": Please enter an integer."); }
            switch (choice) {
                case 1 -> {
                    try {
                        System.out.println("What do you want to set the carb ratio to be (one unit per how many carbs)?");
                        amount = Integer.parseInt(input.next());
                        this.setCarbRatio(amount);
                        chosen = true;
                    } catch (NumberFormatException e) {
                        System.err.println(e + ": Please enter an integer.");
                    }
                }
                case 2 -> {
                    try {
                        System.out.println("What do you want to set the sensitivity to be (one unit per how many glucose)?");
                        amount = Integer.parseUnsignedInt(input.next());
                        this.setSensitivity(amount);
                        chosen = true;
                    } catch (NumberFormatException e) {
                        System.err.println(e + ": Please enter an integer.");
                    }
                }
            }
        }
    }
    public void homeScreen() {
        boolean chosen = false;
        int choice = 0;
        menuLabel: while (!chosen){
            try {
                System.out.println("What do you want to do?\n1. Bolus Wizard\n2. Edit Settings\n3. Test Blood Sugar\n4. View History\n5. Calculate Total Basal Bolus");
                choice = Integer.parseUnsignedInt(input.next());
                //chosen = true;
            } catch (NumberFormatException e) {
                System.err.println(e + ": Please enter an integer.");
            }
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Please enter the amount of carbs (if any) for the current bolus: ");
                        int carbs = Integer.parseInt(input.next());
                        bolusWizard(carbs);
                        //chosen = true;
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println(e + ": Please enter an integer.");
                    }
                case 2:
                    this.editSettings();
                    //chosen = true;
                    break;
                case 3:
                    this.testBloodSugar();
                    break;
                case 4:
                    viewHistory();
                    break;
                case 5:
                    System.out.println("Please enter the amount of hours to calculate: ");
                    double hours = input.nextDouble();
                    System.out.println("The total basal is: " + this.calculateBasal(hours));
                    break;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the insulin pump!");
        InsulinPump pump = new InsulinPump(15, 50, 150, 600, 0);
        pump.homeScreen();
    }
}