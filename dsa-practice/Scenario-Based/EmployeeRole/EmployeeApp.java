public class EmployeeApp {
    public static void main(String[] args) {

        Employee manager = new Manager("Abhay", 100000);
        System.out.printf("%.2f%n", manager.getBonus());

        Employee dev1 = new Developer("Gaurav", 60000);
        System.out.printf("%.2f%n", dev1.getBonus());

        Employee dev2 = new Developer("Deepak", 40000);
        System.out.printf("%.2f%n", dev2.getBonus());
    }
}
