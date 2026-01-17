package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521/orcl123";
    private static final String USERNAME = "hospital_user";
    private static final String PASSWORD = "hospital123";

    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // TEMPORARY TEST (you can remove later)
    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            System.out.println("Database Connected Successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
