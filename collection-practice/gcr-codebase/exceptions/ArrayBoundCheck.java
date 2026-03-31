import java.util.Scanner;

public class ArrayBoundCheck {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arr = null;   

        try {
            System.out.print("Enter array size: ");
            int size = in.nextInt();
            if (size > 0)arr = new int[]{1,2,3,4,5};
            System.out.print("Enter the index: ");
            int index = in.nextInt();
            System.out.println("Element: " + arr[index]);
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized (null reference)");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of range");
        }
//        finally {
//            in.close();
//        }
    }
}
