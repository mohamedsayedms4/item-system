package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionManager {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/ORCLPDB";
    private static final String USER = "itemSys";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("✅ Oracle JDBC Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Oracle JDBC Driver not found: " + e.getMessage());
        }
    }

    private OracleConnectionManager() {}

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                synchronized (OracleConnectionManager.class) {
                    if (connection == null || connection.isClosed()) {
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                        System.out.println("✅ Oracle connection established");
                    }
                }
            }
            return connection;
        } catch (SQLException e) {
            System.err.println("❌ Failed to get Oracle connection: " + e.getMessage());
            throw e;
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
                connection = null;
                System.out.println("✅ Oracle connection closed");
            } catch (SQLException e) {
                System.err.println("❌ Error closing connection: " + e.getMessage());
            }
        }
    }
}