package dao;

import model.Billing;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillingDAO {

    public void addBill(Billing b) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO billing(visit_id,consultation_fee,medicine_cost,total_amount) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, b.getVisitId());
            ps.setDouble(2, b.getConsultationFee());
            ps.setDouble(3, b.getMedicineCost());
            ps.setDouble(4, b.getTotalAmount());

            ps.executeUpdate();

            System.out.println("Bill Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
