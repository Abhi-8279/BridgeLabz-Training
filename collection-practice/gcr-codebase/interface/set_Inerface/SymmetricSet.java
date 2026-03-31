import java.util.HashSet;
import java.util.Set;

public class SymmetricSet {
	public static void main(String[] args) {
		Set<Integer>set1=new HashSet<>();
  	    Set<Integer>set2=new HashSet<>();
  	  set1.add(1);
	  set1.add(2);
	  set1.add(3);
	  set1.add(4);
	  set2.add(3);
	  set2.add(4);
	  set2.add(5);
	  set2.add(6);
	  set2.add(7);
	  Set<Integer> intersection = new HashSet<>(set1);
      intersection.retainAll(set2);
      System.out.println("Set1: "+set1);
      System.out.println("Set2: " +set2);
//      System.out.println("Intersection: " + intersection);
	  set1.addAll(set2);
	  set1.removeAll(intersection);
//	  System.out.println("Union: "+ set1);
	  
	  System.out.println("Symmetric: "+ set1);
	}

}
