package com.clinic.dao;

import com.clinic.model.Doctor;
import com.clinic.util.DBConnection;
import java.sql.*;

public class DoctorDAO {

//    public void addDoctor(Doctor doctor) {
//        String sql = "INSERT INTO doctors(name,contact,consultation_fee,specialty_id) VALUES (?,?,?,?)";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, doctor.getName());
//            ps.setString(2, doctor.getContact());
//            ps.setDouble(3, doctor.getConsultationFee());
//            ps.setInt(4, doctor.getSpecialtyId());
//
//            ps.executeUpdate();
//            System.out.println("Doctor added");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

	public void addDoctor(Doctor doctor) {
	    String checkSql = "SELECT COUNT(*) FROM doctors WHERE contact=?";
	    String insertSql = "INSERT INTO doctors (name, contact, consultation_fee, specialty_id) VALUES (?, ?, ?, ?)";

	    try (Connection conn = DBConnection.getConnection()) {

	        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
	        checkStmt.setString(1, doctor.getContact());

	        ResultSet rs = checkStmt.executeQuery();
	        rs.next();

	        if (rs.getInt(1) > 0) {
	            System.out.println("Doctor already exists!");
	            return;
	        }

	        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
	        insertStmt.setString(1, doctor.getName());
	        insertStmt.setString(2, doctor.getContact());
	        insertStmt.setDouble(3, doctor.getConsultationFee());
	        insertStmt.setInt(4, doctor.getSpecialtyId());

	        insertStmt.executeUpdate();
	        System.out.println("Doctor added!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	public void viewDoctorsBySpecialty(String specialty) {
	    String sql =
	        "SELECT d.name, s.specialty_name " +
	        "FROM doctors d " +
	        "JOIN specialties s ON d.specialty_id = s.specialty_id " +
	        "WHERE s.specialty_name = ?";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, specialty);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            System.out.println(
	                rs.getString("name") + " - " +
	                rs.getString("specialty_name")
	            );
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}