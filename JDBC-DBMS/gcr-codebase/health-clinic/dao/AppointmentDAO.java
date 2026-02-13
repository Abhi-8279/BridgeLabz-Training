package dao;

import model.Appointment;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentDAO {

    public void addAppointment(Appointment a) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setDate(3, a.getDate());
            ps.setTime(4, a.getTime());
            ps.setString(5, a.getStatus());

            ps.executeUpdate();

            System.out.println("Appointment Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
