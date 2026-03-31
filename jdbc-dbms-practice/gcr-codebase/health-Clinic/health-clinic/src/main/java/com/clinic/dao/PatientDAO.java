package com.clinic.dao;
//
import com.clinic.model.Patient;
import com.clinic.util.DBConnection;
import java.sql.*;
//
public class PatientDAO {
//
//    public void addPatient(Patient patient) {
//        String sql = "INSERT INTO patients(name,dob,contact,address,blood_group) VALUES (?,?,?,?,?)";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, patient.getName());
//            ps.setString(2, patient.getDob());
//            ps.setString(3, patient.getContact());
//            ps.setString(4, patient.getAddress());
//            ps.setString(5, patient.getBloodGroup());
//
//            ps.executeUpdate();
//            System.out.println("Patient added");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}



public void registerPatient(Patient patient) {
    String checkSql = "SELECT COUNT(*) FROM patients WHERE phone=? OR email=?";
    String insertSql = "INSERT INTO patients (name, dob, phone, email, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = DBConnection.getConnection()) {

        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setString(1, patient.getphone());
        checkStmt.setString(2, patient.getEmail());

        ResultSet rs = checkStmt.executeQuery();
        rs.next();

        if (rs.getInt(1) > 0) {
            System.out.println("Patient already exists!");
            return;
        }

        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
        insertStmt.setString(1, patient.getName());
        insertStmt.setDate(2, java.sql.Date.valueOf(patient.getDob()));
        insertStmt.setString(3, patient.getphone());
        insertStmt.setString(4, patient.getEmail());
        insertStmt.setString(5, patient.getAddress());
        insertStmt.setString(6, patient.getBloodGroup());

        insertStmt.executeUpdate();
        System.out.println("Patient registered successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}


public void updatePatient(int id, String newPhone, String newAddress) {
    String sql = "UPDATE patients SET phone=?, address=? WHERE patient_id=?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, newPhone);
        ps.setString(2, newAddress);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Patient updated!");
        else
            System.out.println("Patient not found.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void searchPatientByName(String name) {
    String sql = "SELECT * FROM patients WHERE name LIKE ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, "%" + name + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getInt("patient_id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("phone")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void viewVisitHistory(int patientId) {
    String sql =
        "SELECT a.appointment_date, v.diagnosis, d.name AS doctor_name " +
        "FROM appointments a " +
        "JOIN visits v ON a.appointment_id = v.appointment_id " +
        "JOIN doctors d ON a.doctor_id = d.doctor_id " +
        "WHERE a.patient_id = ? " +
        "ORDER BY a.appointment_date";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, patientId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getDate("appointment_date") + " | " +
                rs.getString("doctor_name") + " | " +
                rs.getString("diagnosis")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
