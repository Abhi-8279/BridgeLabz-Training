import java.util.*;
public class LibraryFine {
    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
        for(int i=1;i<=5;i++){
            System.out.println("\nbook" +i);
            System.out.println("Enter due date(day number");
            int dueDate= in.nextInt();
            System.out.print("Enter Return Date (day number): ");
            int returnDate = in.nextInt();
            if(returnDate >dueDate){
                int lateday= returnDate-dueDate;
                int fine= lateday*5;
                System.out.println("Late by " + lateday + " days");
                System.out.println("Fine: ₹" + fine);
            } else System.out.println("Returned on time. No fine.");
            
        }
    }
}
}
