import java.util.*;

public class StringConcatComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of concatenation operations
        System.out.print("Enter number of concatenations (N): ");
        int n = sc.nextInt();

        //  String 
        long startString = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + "a";
        }
        long endString = System.nanoTime();

        //  StringBuilder 
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long endBuilder = System.nanoTime();

        //  StringBuffer 
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("a");
        }
        long endBuffer = System.nanoTime();

        // Output
        System.out.println("\n--- String Concatenation Performance ---");
        System.out.println("String Time        : " + (endString - startString) + " ns");
        System.out.println("StringBuilder Time : " + (endBuilder - startBuilder) + " ns");
        System.out.println("StringBuffer Time  : " + (endBuffer - startBuffer) + " ns");

        sc.close();
    }
}
