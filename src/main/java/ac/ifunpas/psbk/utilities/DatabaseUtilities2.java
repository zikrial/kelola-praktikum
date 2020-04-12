package ac.ifunpas.psbk.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilities2 {

    public static Connection getConnection() {
        return getConnection("jdbc:mysql://localhost:3306/db_tubes_psi", "root", "admin");
    }

    private static Connection getConnection(String url, String user, String pass) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return con;
    }
}
