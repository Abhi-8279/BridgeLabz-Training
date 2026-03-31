import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        
        double[][] data = new double[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for person " + (i + 1));
            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }
        
        String[][] result = calculateBMI(data);
        
      
        displayResult(result);
        
        sc.close();
    }
    
  
    public static String[][] calculateBMI(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4];
        
        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double height = data[i][1] / 100; // cm to m
            double bmi = weight / (height * height);
            String status = getStatus(bmi);
            
            result[i][0] = String.format("%.2f", height * 100); // height in cm
            result[i][1] = String.format("%.2f", weight); // weight in kg
            result[i][2] = String.format("%.2f", bmi); // BMI
            result[i][3] = status; // status
        }
        return result;
    }
    
    public static String getStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }
    
    public static void displayResult(String[][] result) {
        System.out.println("\nPerson Details (Height, Weight, BMI, Status):");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        for (String[] row : result) {
            System.out.printf("%-10s %-10s %-10s %-10s\n", row[0], row[1], row[2], row[3]);
        }
    }
}