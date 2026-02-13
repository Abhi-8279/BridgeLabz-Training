package main;

import dao.PatientDAO;
import model.Patient;

import java.sql.Date;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientDAO patientDAO = new PatientDAO();

        while (true) {

            System.out.println("\n--- Clinic System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Patient p = new Patient();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    p.setName(sc.nextLine());

                    System.out.print("Enter DOB (YYYY-MM-DD): ");
                    p.setDob(Date.valueOf(sc.nextLine()));

                    System.out.print("Enter Phone: ");
                    p.setPhone(sc.nextLine());

                    System.out.print("Enter Email: ");
                    p.setEmail(sc.nextLine());

                    System.out.print("Enter Address: ");
                    p.setAddress(sc.nextLine());

                    System.out.print("Enter Blood Group: ");
                    p.setBloodGroup(sc.nextLine());

                    patientDAO.addPatient(p);
                    break;

                case 2:
                    System.exit(0);
            }
        }
    }
}
