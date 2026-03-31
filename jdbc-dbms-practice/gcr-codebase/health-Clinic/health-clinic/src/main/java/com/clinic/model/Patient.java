package com.clinic.model;

public class Patient {
    private int patientId;
    private String name;
    private String dob;
    private String contact;
    private String address;
    private String bloodGroup;
    private String email;

    public Patient() {}

    public Patient(String name, String dob, String phone,String email,String address, String bloodGroup) {
        this.name = name;
        this.dob = dob;
        this.contact = phone;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.setEmail(email);
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getphone() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

	public String getEmail() {return email;	}
	public void setEmail(String email) {this.email = email;
	}

	
}
