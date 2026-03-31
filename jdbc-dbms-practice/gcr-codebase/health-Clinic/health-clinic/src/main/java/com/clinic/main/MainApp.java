package com.clinic.main;

import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.DoctorDAO;
import com.clinic.dao.PatientDAO;
import com.clinic.model.Appointment;
import com.clinic.model.Doctor;
import com.clinic.model.Patient;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        // Add patient
        Patient patient = new Patient("Rahul","2004-09-12", "9876543210","rahul@gmail.com" ,"Ghazianbad","A+");
        patientDAO.registerPatient(patient);
        Patient patient2 = new Patient("Gaurav mangal","2004-12-06", "9876564420","magal@gmail.com" ,"Dholpur sarMAthura","L+");
        patientDAO.registerPatient(patient2);
        // Add doctor
        Doctor doctor = new Doctor("Dr. Abhay", "9999999999", 9500.767, 1);
        doctorDAO.addDoctor(doctor);

        Appointment appt = new Appointment(1, 1,LocalDate.now().toString(),"10:30:00", "SCHEDULED");


        appointmentDAO.bookAppointment(appt);
       
        System.out.println("Searching for Patient "+patient.getName());
        
        PatientDAO patientDAO1 = new PatientDAO();
        patientDAO1.searchPatientByName("Rahul");
        System.out.println("---------------------------");

        DoctorDAO doctorDAO1 = new DoctorDAO();
        doctorDAO1.viewDoctorsBySpecialty("Cardiology");

    }
}
