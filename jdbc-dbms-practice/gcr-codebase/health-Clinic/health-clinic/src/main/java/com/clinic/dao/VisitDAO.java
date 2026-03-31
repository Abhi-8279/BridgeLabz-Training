package com.clinic.dao;

//import com.clinic.model.Visit;

import com.clinic.util.DBConnection;
import java.sql.*;

public class VisitDAO {

//    public void recordVisit(Visit visit) {
//        String sql = "INSERT INTO visits(appointment_id,diagnosis,notes) VALUES (?,?,?)";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setInt(1, visit.getAppointmentId());
//            ps.setString(2, visit.getDiagnosis());
//            ps.setString(3, visit.getNotes());
//
//            ps.executeUpdate();
//            System.out.println("Visit recorded");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

	public void recordVisit(int appointmentId, String diagnosis, String notes) {

	    String insertVisit =
	        "INSERT INTO visits (appointment_id, diagnosis, notes, visit_date) " +
	        "VALUES (?, ?, ?, CURDATE())";

	    String updateAppt =
	        "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";

	    try (Connection conn = DBConnection.getConnection()) {

	        conn.setAutoCommit(false);

	        PreparedStatement ps1 = conn.prepareStatement(insertVisit);
	        ps1.setInt(1, appointmentId);
	        ps1.setString(2, diagnosis);
	        ps1.setString(3, notes);
	        ps1.executeUpdate();

	        PreparedStatement ps2 = conn.prepareStatement(updateAppt);
	        ps2.setInt(1, appointmentId);
	        ps2.executeUpdate();

	        conn.commit();
	        System.out.println("Visit recorded!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
