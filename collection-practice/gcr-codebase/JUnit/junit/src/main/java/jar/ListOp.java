package jar;

import java.util.*;
public class ListOp {
	public static void addElement(List<Integer> list, int element) {
		list.add(element);
	}
	
	public static void removeElement(List<Integer> list, int element) {
		list.remove(Integer.valueOf(element));
	}
	
	public static int getSize(List<Integer> list) {
        return list.size();
    }
}