import java.util.ArrayList;
import java.util.List;

public class ReverseList {

	public static void main(String[] args) {
		List<Integer>l=new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		System.out.println("Before reversing");
		System.out.println(l);
		List<Integer>l2=new ArrayList<>();
		for(int i=l.size()-1;i>=0;i--)l2.add(l.get(i));
		System.out.println("After Reversing");
		System.out.println(l2);
		
//		for(int i=0;i<l2.size();i++)
//		{
//			System.out.println(l2.get(i));
//		}

	}

}
