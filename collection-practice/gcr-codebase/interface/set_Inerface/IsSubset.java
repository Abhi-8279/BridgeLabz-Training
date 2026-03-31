import java.util.*;

public class IsSubset {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        boolean isSub = set2.containsAll(set1);

        System.out.println(isSub);
    }
}
