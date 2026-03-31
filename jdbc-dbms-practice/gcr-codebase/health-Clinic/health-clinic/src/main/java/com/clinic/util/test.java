package com.clinic.util;
import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("Connected to database!");
        } else {
            System.out.println("Connection failed.");
        }
    }
}
