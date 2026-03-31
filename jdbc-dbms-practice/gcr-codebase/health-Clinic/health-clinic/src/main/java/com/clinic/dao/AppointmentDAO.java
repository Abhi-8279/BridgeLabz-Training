package com.clinic.dao;

import com.clinic.model.Appointment;
import com.clinic.util.DBConnection;
import java.sql.*;

public class AppointmentDAO {

//    public void bookAppointment(Appointment appt) {
//        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES (?,?,?,?,?)";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setInt(1, appt.getPatientId());
//            ps.setInt(2, appt.getDoctorId());
//            ps.setString(3, appt.getDate());
//            ps.setString(4, appt.getTime());
//            ps.setString(5, appt.getStatus());
//
//            ps.executeUpdate();
//            System.out.println("Appointment booked");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

	
	public void bookAppointment(Appointment appointment) {

	    String checkSql =
	        "SELECT COUNT(*) FROM appointments " +
	        "WHERE doctor_id=? AND appointment_date=? AND appointment_time=?";

	    String insertSql =
	        "INSERT INTO appointments " +
	        "(patient_id, doctor_id, appointment_date, appointment_time, status) " +
	        "VALUES (?, ?, ?, ?, 'SCHEDULED')";

	    try (Connection conn = DBConnection.getConnection()) {

	        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
	        checkStmt.setInt(1, appointment.getDoctorId());
	        checkStmt.setDate(2, java.sql.Date.valueOf(appointment.getDate()));
	        checkStmt.setTime(3, java.sql.Time.valueOf(appointment.getTime()));

	        ResultSet rs = checkStmt.executeQuery();
	        rs.next();

	        if (rs.getInt(1) > 0) {
	            System.out.println("Slot already booked!");
	            return;
	        }

	        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
	        insertStmt.setInt(1, appointment.getPatientId());
	        insertStmt.setInt(2, appointment.getDoctorId());
	        insertStmt.setDate(3, java.sql.Date.valueOf(appointment.getDate()));
	        insertStmt.setTime(4, java.sql.Time.valueOf(appointment.getTime()));

	        insertStmt.executeUpdate();
	        System.out.println("Appointment booked!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}