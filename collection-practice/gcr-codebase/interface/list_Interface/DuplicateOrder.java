import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateOrder {
	public static void main(String[] args) {
		List<Integer>list=new ArrayList<>();
		list.add(5);
		list.add(98);
		list.add(97);
		list.add(99);
		list.add(99);
		list.add(97);
		list.add(98);
		list.add(5);
		Set<Integer>set=new LinkedHashSet<>();
		set.addAll(list);
		System.out.println(set);
		
	}

}
