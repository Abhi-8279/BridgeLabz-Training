package dao;

import model.Visit;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VisitDAO {

    public void addVisit(Visit v) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO visits(appointment_id,patient_id,doctor_id,visit_date,diagnosis,treatment_notes) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, v.getAppointmentId());
            ps.setInt(2, v.getPatientId());
            ps.setInt(3, v.getDoctorId());
            ps.setDate(4, v.getVisitDate());
            ps.setString(5, v.getDiagnosis());
            ps.setString(6, v.getNotes());

            ps.executeUpdate();

            System.out.println("Visit Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

