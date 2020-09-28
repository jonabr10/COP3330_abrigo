import java.text.DecimalFormat;

public class BodyMassIndex {
    private double bmi;

    public BodyMassIndex(double height, double weight) {
        this.bmi = calculateBMI(height, weight);
    }

    public BodyMassIndex() {
        this.bmi = 0.00;
    }

    // Criteria 9: 2pts
    public double calculateBMI(double height, double weight) {
        return 703 * weight / Math.pow(height, 2);
    }

    // Criteria 10: 2pts
    public String calculateCategory() {
        if (bmi < 18.5) {
            return "(Underweight < 18.5)";
        } else if (bmi <= 24.9) {
            return "(Normal weight = 18.5 - 24.9)";
        } else if (bmi <= 29.9) {
            return "(Overweight = 25 - 29.9)";
        } else {
            return "(Obesity >= 30.0)";
        }
    }

    public double getBMI() {
        return bmi;
    }

    public String getBMIData() {
        String pattern = "#.##";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        return decimalFormat.format(bmi) + " " + calculateCategory();
    }
}
