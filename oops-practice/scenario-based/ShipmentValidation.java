import java.util.*;
import java.util.regex.*;

public class ShipmentValidation{
	
	static boolean isValidateCode(String code) {
		if(!code.matches("^SHIP-[1-9]\\d{5}$")) return false;
		
		String digit=code.substring(5);
		return !digit.matches(".*(\\d)\\1{3}.*");
	}
	
	static boolean isLeap(int year) {
		
		
		
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}
	
	static boolean isValidDate(String date) {
		if(!date.matches("^(20\\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) return false;
		
		String[] parts=date.split("-");
		int y=Integer.parseInt(parts[0]);
		int m=Integer.parseInt(parts[1]);
		int d=Integer.parseInt(parts[2]);
		
		int[] days= {31,isLeap(y) ? 29 : 28,31,30,31,30,31,31,30,31,30,31};
		
		return d <= days[m-1];
		}
	
	 static boolean isValidMode(String mode) {
	        return mode.matches("AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT");
	    }
	 static boolean isValidWeight(String w) {
	        if (!w.matches("^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$"))
	            return false;
	        
	        double val = Double.parseDouble(w);
	        return val <= 999999.99;
	 } 
	 
	 static boolean isValidStatus(String s) {
	        return s.matches("DELIVERED|CANCELLED|IN_TRANSIT");
	    }

	 
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = Integer.parseInt(sc.nextLine());

	        while (n-- > 0) {
	            String line = sc.nextLine();
	            String[] parts = line.split("\\|");

	            if (parts.length != 5) {
	                System.out.println("NON-COMPLIANT RECORD");
	                continue;
	            }

	            boolean valid =
	                isValidateCode(parts[0]) &&
	                isValidDate(parts[1]) &&
	                isValidMode(parts[2]) &&
	                isValidWeight(parts[3]) &&
	                isValidStatus(parts[4]);

	            System.out.println(valid ?
	                "COMPLIANT RECORD" :
	                "NON-COMPLIANT RECORD");
	        }
	 }
}

	 