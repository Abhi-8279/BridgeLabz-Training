package HMS;

public class HospitalManagementSystum {
    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Rahul", 30, "Male", 5, 2000);
        Patient p2 = new OutPatient(102, "Neha", 25, "Female", 500);
        Patient p3 = new InPatient(971, "Rishi", 85, "Male", 45, 8000);
        Patient p4= new InPatient(111, "Deepak", 22, "Female", 11, 9000);

        Doctor d1 = new Doctor(1, "Dr. Sharma", "Male");
        Doctor d2=new Doctor(2,"Dr. Abhay","Male");
        Doctor d3 = new Doctor(3, "Dr. Gaurav", "male");
        Doctor d4=new Doctor(4,"Dr. Anu","Female");

        System.out.println("DoctorID     Dr Name     Gender");
        d1.displayDoctor();
        d2.displayDoctor();
        d3.displayDoctor();
        d4.displayDoctor();
        
        System.out.println("\n----- Patient 1 -----");
        p1.displayInfo();

        System.out.println("\n----- Patient 2 -----");
        p2.displayInfo();
        System.out.println("\n----- Patient 3 -----");
         p3.displayInfo();
        System.out.println("\n----- Patient 4 -----");
       p4.displayInfo();
        
    }
}