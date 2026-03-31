import java.util.Scanner;

class YoungestFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int amarAge = sc.nextInt();
        int amarHeight = sc.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int akbarAge = sc.nextInt();
        int akbarHeight = sc.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int anthonyAge = sc.nextInt();
        int anthonyHeight = sc.nextInt();

        // Youngest
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            System.out.println("Amar is the youngest");
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            System.out.println("Akbar is the youngest");
        } else {
            System.out.println("Anthony is the youngest");
        }

        // Tallest
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            System.out.println("Amar is the tallest");
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            System.out.println("Akbar is the tallest");
        } else {
            System.out.println("Anthony is the tallest");
        }

        sc.close();
    }
}

