//import java.util.PriorityQueue;

import java.util.HashSet;
import java.util.Set;

public class SetEquality {
    public static void main(String[] args) {

    	  Set<Integer>set1=new HashSet<>();
    	  Set<Integer>set2=new HashSet<>();
    	  set1.add(1);
    	  set1.add(2);
    	  set1.add(3);
    	  set1.add(4);
    	  set1.add(5);
    	  set1.add(6);
    	  set1.add(7);
    	  set2.add(1);
    	  set2.add(2);
    	  set2.add(3);
    	  set2.add(4);
    	  set2.add(5);
    	  set2.add(6);
    	  set2.add(7);
    	  System.out.println(set1.equals(set2));
  	      set2.add(33);
  	      System.out.println(set1.equals(set2));
    	    }
    
}
