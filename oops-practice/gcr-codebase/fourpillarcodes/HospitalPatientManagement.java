import java.util.*;
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    // sensitive data
    private String diagnosis;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters / Setters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    // Abstract method
    abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;
    private List<String> records = new ArrayList<>();

    InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;
    private List<String> records = new ArrayList<>();

    OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + records);
    }
}

public class HospitalPatientManagement {
	public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient(101, "Rohit", 30, 5, 2000);
        Patient p2 = new OutPatient(102, "Anita", 25, 500);

        patients.add(p1);
        patients.add(p2);

        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Bill Amount: ₹" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord m = (MedicalRecord) p;
                m.addRecord("General Checkup");
                m.addRecord("Blood Test");
                m.viewRecords();
            }
            System.out.println("---------------------------");
        }
	}
}