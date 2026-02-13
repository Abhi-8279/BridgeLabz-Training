package dao;

import model.Prescription;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrescriptionDAO {

    public void addPrescription(Prescription p) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO prescriptions(visit_id,medicine_name,dosage,duration) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, p.getVisitId());
            ps.setString(2, p.getMedicine());
            ps.setString(3, p.getDosage());
            ps.setString(4, p.getDuration());

            ps.executeUpdate();

            System.out.println("Prescription Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
