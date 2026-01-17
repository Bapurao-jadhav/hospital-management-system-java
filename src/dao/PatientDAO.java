package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBConnection;

public class PatientDAO {

    public void addPatient(int id, String name, int age,
                           String gender, String disease, String phone) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO patient VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setString(5, disease);
            ps.setString(6, phone);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient added successfully");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
