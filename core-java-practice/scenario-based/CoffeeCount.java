import java.util.Scanner;

public class CoffeeCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter the type of Coffee(Latte,Espresso,Cappuccino) and Enter exit to quit.");
            String type = in.next();

            if(type.equalsIgnoreCase("exit")) {
                System.out.println("Exiting. Thank you!");
                break;
            }

            System.out.println("Enter Quantity");
            int quantity = in.nextInt();
            int price = 0;
            if(type.equalsIgnoreCase("latte")){
                price = 100;
            }
            else if(type.equalsIgnoreCase("espresso")){
                price = 150;
            }
            else if(type.equalsIgnoreCase("cappuccino")){
                price = 200;
            }
            else{
                System.out.println("Invalid coffee type! Try again.");
                continue;
            }
            double total = price * quantity;
            double tax = total * 0.18;
            double finalBill = total + tax;

            System.out.println("Total: " + total);
            System.out.println("GST (18%): " + tax);
            System.out.println("Final Bill: " + finalBill);
            System.out.println("Thankyou for coming...");
            
        }
    }
}
