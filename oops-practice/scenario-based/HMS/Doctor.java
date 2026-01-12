package HMS;

class Doctor {
    private int doctorId;
    private String doctorName;
    private String gender;

    public Doctor(int doctorId, String doctorName, String gender) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.gender = gender;
    }

    public void displayDoctor() {
        System.out.println(doctorId+"         "+doctorName+ "           "+gender);
    }
}