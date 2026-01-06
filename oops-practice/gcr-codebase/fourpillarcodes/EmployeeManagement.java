import java.util.ArrayList;
import java.util.List;

/* -------- Interface -------- */
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

/* -------- Abstract Class -------- */
abstract class Employee implements Department {

    // Encapsulation
    private int employeeId;
    private String name;
    protected double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + calculateSalary());
        System.out.println("----------------------------");
    }

    // Getters & Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Interface methods
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

/* -------- Full Time Employee -------- */
class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

/* -------- Part Time Employee -------- */
class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

/* -------- Main Class -------- */
public class EmployeeManagement	{

    public static void main(String[] args) {

        // Polymorphism using Employee reference
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new FullTimeEmployee(1, "Rahul", 50000);
        Employee emp2 = new PartTimeEmployee(2, "Anita", 500, 40);

        emp1.assignDepartment("IT");
        emp2.assignDepartment("HR");

        employees.add(emp1);
        employees.add(emp2);

        // Display employee details
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
