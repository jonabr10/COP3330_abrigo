import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    // Criteria 4: 2pts
    public static boolean moreInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to input a BMI data? (Y or N)");
        String choice = input.nextLine();

        // Note: Just to take into account an upper/lowercase 'Y'
        choice = choice.toLowerCase();

        return choice.equals("y");
    }

    // Criteria 5: 2pts
    public static double getUserHeight() {
        Scanner input = new Scanner(System.in);
        double height = 0.00;

        while (height <= 0) {
            System.out.println("Input Height (positive values only):");
            height = input.nextDouble();
        }

        return height;
    }

    // Criteria 6: 2pts
    public static double getUserWeight() {
        Scanner input = new Scanner(System.in);
        double weight = 0.00;

        while (weight <= 0) {
            System.out.println("Input Weight (positive values only):");
            weight = input.nextDouble();
        }

        return weight;
    }

    // Criteria 7: 2pts
    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("BMI score: " + bmi.getBMIData() + "\n");
    }

    // Criteria 8: 2pts
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double sum = 0;

        for (BodyMassIndex x: bmiData) {
            sum += x.getBMI();
        }

        System.out.printf("Average: %.2f", (sum / bmiData.size()));
    }

}


