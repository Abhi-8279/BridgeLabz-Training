import java.util.Scanner;

public class MetroSmartcard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 200; 

        while (balance > 0) {

            System.out.println("\nCurrent Balance: ₹" + balance);
            System.out.print("Enter distance in km (or -1 to quit): ");
            int distance = sc.nextInt();

           
            if (distance == -1) {
                break;
            }
            double fare = (distance <= 5) ? 20 :
                          (distance <= 15) ? 40 : 60;

            if (balance >= fare) {
                balance = balance - fare;
                System.out.println("Fare Deducted: ₹" + fare);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("\nTransaction ended. Remaining balance: ₹" + balance);
    
    }
}
