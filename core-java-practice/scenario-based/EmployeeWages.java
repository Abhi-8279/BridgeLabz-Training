import java.util.Random;
public class EmployeeWages {
public static void main(String[] args) {
	   System.out.println("Welcome to Employee Wage Computation");
	   //Checked wheather the employee is present or absent using the Randm buildin methods
	   Random random = new Random();
       int attend = random.nextInt(2);
       if (attend== 1) {
    	   System.out.println("Employee is Present");
       
     //Daily Employee Wage
       int wageperHour=20;
       int working_hrs=8;
       int wageforday=wageperHour*working_hrs;
       System.out.println("Full day Employee Wage is "+ wageforday);
       
     //PartTime Employee Wage
       int PartTime=8;
       System.out.println("Part Time Employee Wage is "+wageperHour*PartTime);
       
       
     // Calculating Wages per month
       int noofDays=20;
       System.out.println("The Wage for a month is "+wageforday*noofDays);
       
      //Calculation for Condition 
       int hrs=100;
       int days=20;
       int working=hrs/days;
       int finlWage=(working+noofDays)*wageperHour;
       System.out.println("Wages for the provided condition is "+finlWage);
      
       }
       
       
       else System.out.println("Employee is Absent");
       
}
}
