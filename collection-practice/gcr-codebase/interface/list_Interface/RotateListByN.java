import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateListByN {
	public static void main(String[] args) {
		List <Integer>list=new ArrayList<>();
		List <Integer>list2=new ArrayList<>();
		list.add(1);
		list.add(9);
		list.add(4);
		list.add(6);
		list.add(5);
		list.add(1);
		list.add(8);
		System.out.println("Enter the N for rotation by\n");
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		System.out.println("List Before Rotation\n"+list);
		for(int i=n;i<list.size();i++)list2.add(list.get(i));
		for(int i=0;i<n;i++)list2.add(list.get(i));
		System.out.println("List After Rotation");

		System.out.println(list2);
	}

}
