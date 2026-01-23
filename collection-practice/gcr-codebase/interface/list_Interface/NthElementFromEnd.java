import java.util.LinkedList;
import java.util.Scanner;

public class NthElementFromEnd {

    public static String findNthFromEnd(LinkedList<String> list,int n) {
        if (n<=0 || list==null)return null;
        int fast=0;
        int slow=0;
        for (int i=0;i<n;i++) {
            if(fast>=list.size())return null;
            fast++;
        }

        while(fast<list.size()) {
            fast++;
            slow++;
        }

        return list.get(slow);
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the N for the value ");
        int N=in.nextInt();
        System.out.println(findNthFromEnd(list, N)); 
    }
}
