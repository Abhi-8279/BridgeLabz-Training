package HMS;

class Patient {
    private int patientId;
    private String name;
    private int age;
    private String gender;

    public Patient(int patientId, String name, int age, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
    }
}