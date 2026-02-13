package dao;

import model.Patient;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientDAO {

    public void addPatient(Patient p) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO patients(name,dob,phone,email,address,blood_group) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getName());
            ps.setDate(2, p.getDob());
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getBloodGroup());

            ps.executeUpdate();

            System.out.println("Patient Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
