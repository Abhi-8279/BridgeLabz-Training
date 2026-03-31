import java.util.*;

//InterFace
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}
//abstract class
abstract class Employee{
	private int empID;
	private String empName;
	protected double baseSalary;
	
	
	public Employee(int empID,String empName,double baseSalary){
		this.empID = empID;
		this.empName = empName;
		this.baseSalary = baseSalary;
	}
	 // Getters & Setters
    public int getEmployeeId() {
        return empID;
    }

    public void setEmployeeId(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return empName;
    }

    public void setName(String name) {
        this.empName = empName;
    }
	//abstract method 
	public abstract double calculateSalary();
	// non method
	public void displayDetails() {
		System.out.println("Employee Name: "+ empName);
		System.out.println("Employee-ID: "+empID);
		System.out.println("Employee Salary: "+ baseSalary);
	}
}
//full time employee class
class FullTimeEmployee extends Employee implements Department{
	private String department;
	
	public FullTimeEmployee(int empID, String empName, double baseSalary) {
		super(empID, empName, baseSalary);
		
	}
	@Override
	public double calculateSalary() {
		
		return baseSalary;
	}

	@Override
	public void assignDepartment(String deptName) {
		this.department = deptName;
		
	}

	@Override
	public String getDepartmentDetails() {
		// TODO Auto-generated method stub
		return department;
	}
	
}
//part Time Employee class
class PartTimeEmployee extends Employee implements Department{
	 private int hoursWorked;
	 private String department;
	public PartTimeEmployee(int empID, String empName, double baseSalary,int hoursWorked) {
		super(empID, empName, baseSalary);
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		double perDay=baseSalary/30;
		double perHours = perDay/4;
		double perMonth = perDay*30;
		return baseSalary+perMonth;
	}

	@Override
	public void assignDepartment(String deptName) {
		this.department = deptName;
		
	}

	@Override
	public String getDepartmentDetails() {
		// TODO Auto-generated method stub
		return department;
	}
	
}
//Main class
public class Employee3 {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Employee e1 = new FullTimeEmployee(101, "Rohit", 50000);
        Employee e2 = new PartTimeEmployee(102, "Anita", 500, 40);
        Employee e3 = new FullTimeEmployee(103,"Abhishek",60000);
        ((Department) e1).assignDepartment("IT");
        ((Department) e2).assignDepartment("HR");
        ((Department) e3).assignDepartment("IT");
        
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
     // Polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: " +
                    ((Department) emp).getDepartmentDetails());
            System.out.println("--------------------");
        }
	}
}