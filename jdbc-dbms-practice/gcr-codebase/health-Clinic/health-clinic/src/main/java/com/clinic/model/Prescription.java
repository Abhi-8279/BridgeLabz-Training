package com.clinic.model;

public class Prescription {
    private int prescriptionId;
    private int visitId;
    private String medicineName;
    private String dosage;
    private String duration;

    public Prescription() {}

    public Prescription(int visitId, String medicineName,
                        String dosage, String duration) {
        this.visitId = visitId;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.duration = duration;
    }

    // getters and setters
}
