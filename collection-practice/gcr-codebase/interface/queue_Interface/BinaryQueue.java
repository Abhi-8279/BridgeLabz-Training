import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

	public class BinaryQueue {

	    public static List<String> generateBinary(int N) {
	        List<String> result = new ArrayList<>();
	        Queue<String> q = new LinkedList<>();
	        q.add("1");
	        for (int i = 0; i < N; i++) {
	            String current = q.remove();
	            result.add(current);
	            q.add(current + "0");
	            q.add(current + "1");
	        }
	        return result;
	    }
	    public static void main(String[] args) {
	        int N = 10;
	        System.out.println(generateBinary(N));
	    }
	}

