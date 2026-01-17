package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class DoctorDAO {

    public void addDoctor(int id, String name,
                          String specialization, String phone) {

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO doctor VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, specialization);
            ps.setString(4, phone);

            ps.executeUpdate();
            con.close();

            System.out.println("Doctor added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewDoctors() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM doctor";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Doctor List ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("doctor_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("specialization") + " | " +
                    rs.getString("phone")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
