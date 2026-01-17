package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import util.DBConnection;

public class AppointmentDAO {

    public void bookAppointment(int appId, int patientId,
                                int doctorId, Date appDate) {

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO appointment VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appId);
            ps.setInt(2, patientId);
            ps.setInt(3, doctorId);
            ps.setDate(4, appDate);

            ps.executeUpdate();
            con.close();

            System.out.println("Appointment booked successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAppointments() {

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT appointment_id, patient_id, doctor_id, appointment_date FROM appointment";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Appointment List ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("appointment_id") + " | " +
                    rs.getInt("patient_id") + " | " +
                    rs.getInt("doctor_id") + " | " +
                    rs.getDate("appointment_date")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
