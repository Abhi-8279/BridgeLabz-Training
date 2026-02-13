package dao;

import model.Doctor;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorDAO {

    public void addDoctor(Doctor d) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO doctors(doctor_name,specialization,phone,email) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, d.getDoctorName());
            ps.setString(2, d.getSpecialization());
            ps.setString(3, d.getPhone());
            ps.setString(4, d.getEmail());

            ps.executeUpdate();

            System.out.println("Doctor Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
