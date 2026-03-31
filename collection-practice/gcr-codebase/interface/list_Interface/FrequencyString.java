import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyString {
    
	public static void main(String[] args) {
	List<String>list=new ArrayList<>();
	list.add("abhay");
	list.add("ay");
	list.add("abhi");
	list.add("abhay");
	list.add("abhi");
	list.add("ay");
	list.add("ay");
	list.add("abhi");
	System.out.println(list);
	System.out.println("After aplying map");
	Map<String,Integer>map=new HashMap<>();
	for(int i=0;i<list.size();i++)
	{
		 map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
	}
	
	System.out.println(map);
	
	
}
}
