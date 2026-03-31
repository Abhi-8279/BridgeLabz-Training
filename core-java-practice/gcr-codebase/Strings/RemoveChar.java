import java.util.Scanner;

public class RemoveChar {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str =in.nextLine();
        char ch =in.nextLine().charAt(0);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)!=ch) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
