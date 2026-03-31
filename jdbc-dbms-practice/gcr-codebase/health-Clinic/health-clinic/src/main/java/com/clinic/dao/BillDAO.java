package com.clinic.dao;

import com.clinic.util.DBConnection;
import java.sql.*;

public class BillDAO {

//    /public void generateBill(int visitId, double amount) {
//        String sql = "INSERT INTO bills(visit_id,total_amount,payment_status) VALUES (?,?,?)";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setInt(1, visitId);
//            ps.setDouble(2, amount);
//            ps.setString(3, "UNPAID");
//
//            ps.executeUpdate();
//            System.out.println("Bill generated");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

	public void generateBill(int visitId, double amount) {

	    String sql =
	        "INSERT INTO bills (visit_id, total_amount, payment_status) " +
	        "VALUES (?, ?, 'UNPAID')";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, visitId);
	        ps.setDouble(2, amount);

	        ps.executeUpdate();
	        System.out.println("Bill generated!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
