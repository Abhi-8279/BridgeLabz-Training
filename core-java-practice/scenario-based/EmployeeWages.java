
import java.util.ArrayList;
import java.util.Random;

public class EmployeeWages {

    // UC Constants
    static final int IS_PART_TIME = 1;
    static final int IS_FULL_TIME = 2;

    // UC10 Collection to store companies
    ArrayList<CompanyEmpWage> companyList = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        Random random = new Random();

        
        // UC1 Check Employee Present or Absent
        

        int empCheck = random.nextInt(2);

        if (empCheck == 1)
            System.out.println("UC1: Employee is Present");

        else
            System.out.println("UC1: Employee is Absent");


        
        // UC2 Calculate Daily Wage
        

        int empHrs = (empCheck == 1) ? 8 : 0;

        int dailyWage = empHrs * 20;

        System.out.println("UC2: Daily Wage = " + dailyWage);


        
        // UC3 Part Time and Full Time
        

        empCheck = random.nextInt(3);

        if (empCheck == IS_FULL_TIME)

            empHrs = 8;

        else if (empCheck == IS_PART_TIME)

            empHrs = 4;

        else

            empHrs = 0;

        System.out.println("UC3: Wage = " + empHrs * 20);


        
        // UC4 Using Switch Case
        

        empCheck = random.nextInt(3);

        switch (empCheck) {

            case IS_FULL_TIME:
                empHrs = 8;
                break;

            case IS_PART_TIME:
                empHrs = 4;
                break;

            default:
                empHrs = 0;
        }

        System.out.println("UC4: Wage using Switch = " + empHrs * 20);


        
        // UC5 Monthly Wage
        

        int totalWage = 0;

        for (int day = 1; day <= 20; day++) {

            empCheck = random.nextInt(3);

            switch (empCheck) {

                case IS_FULL_TIME:
                    empHrs = 8;
                    break;

                case IS_PART_TIME:
                    empHrs = 4;
                    break;

                default:
                    empHrs = 0;
            }

            totalWage += empHrs * 20;
        }

        System.out.println("UC5: Monthly Wage = " + totalWage);



        
        // UC6 Max Hours Limit
        

        int totalHours = 0;

        int totalDays = 0;

        while (totalHours <= 100 && totalDays < 20) {

            totalDays++;

            empCheck = random.nextInt(3);

            switch (empCheck) {

                case IS_FULL_TIME:
                    empHrs = 8;
                    break;

                case IS_PART_TIME:
                    empHrs = 4;
                    break;

                default:
                    empHrs = 0;
            }

            totalHours += empHrs;
        }

        System.out.println("UC6: Total Wage = " + totalHours * 20);



        
        // UC7 to UC10 Using OOP
        

        EmployeeWageComputation builder =
                new EmployeeWageComputation();

        builder.addCompany("TCS", 20, 20, 100);

        builder.addCompany("Infosys", 30, 22, 120);

        builder.addCompany("Wipro", 25, 18, 90);

        builder.computeAllWages();

    }



    
    // UC10 Add Company
    

    public void addCompany(String companyName,
                           int rate,
                           int days,
                           int hours) {

        // Regex validation
        if (!companyName.matches("^[A-Za-z]+$")) {

            System.out.println("Invalid Company Name");

            return;
        }

        CompanyEmpWage company =
                new CompanyEmpWage(companyName,
                        rate,
                        days,
                        hours);

        companyList.add(company);

    }



    
    // UC10 Compute All
    

    public void computeAllWages() {

        for (CompanyEmpWage company : companyList) {

            computeEmpWage(company);

        }

    }



    
    // UC7 UC8 UC9 Method
   

   public void computeEmpWage(CompanyEmpWage company) {

        int totalHours = 0;

        int totalDays = 0;

        Random random = new Random();

      while (totalHours <= company.maxHours
         && totalDays < company.maxDays) {

            totalDays++;

            int empCheck = random.nextInt(3);

            int empHrs = 0;

            switch (empCheck) {

                case IS_FULL_TIME:
                    empHrs = 8;
                    break;

                case IS_PART_TIME:
                    empHrs = 4;
                    break;

                default:
                    empHrs = 0;
            }

            totalHours += empHrs;

        }

      company.totalWage =
                totalHours * company.rate;

      System.out.println("UC10: Company "
               + company.name
               + " Total Wage = "
               + company.totalWage);

   }



    
    // UC9 Company Class
    

    class CompanyEmpWage {

        String name;

        int rate;

        int maxDays;

        int maxHours;

        int totalWage;


        CompanyEmpWage(String name,
                       int rate,
                       int maxDays,
                       int maxHours) {

            this.name = name;

            this.rate = rate;

            this.maxDays = maxDays;

            this.maxHours = maxHours;

        }

    }

}