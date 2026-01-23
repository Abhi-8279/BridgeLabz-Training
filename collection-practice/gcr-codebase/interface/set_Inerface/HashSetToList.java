import java.util.*;

public class HashSetToList {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);
        set.add(34);
        set.add(2);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("Ascending : "+list);
        List<Integer> list2 = new ArrayList<>(set);
        Collections.sort(list2,Collections.reverseOrder());
        System.out.println("Descending : "+list2);
        
    }
}
