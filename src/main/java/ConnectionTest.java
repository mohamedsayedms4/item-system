import java.sql.*;

import util.OracleConnectionManager;

public class ConnectionTest {
    public static void main(String[] args) {
        testConnection();
    }
    
    public static void testConnection() {
        System.out.println("🧪 Testing Oracle Database Connection...");
        
        Connection conn = null;
        try {
            conn = OracleConnectionManager.getConnection();
            System.out.println("✅ Connection successful!");
            
            // Test database info
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("📊 Database: " + metaData.getDatabaseProductName());
            System.out.println("📊 Version: " + metaData.getDatabaseProductVersion());
            System.out.println("📊 URL: " + metaData.getURL());
            
            // Test if table exists
            String[] types = {"TABLE"};
            ResultSet rs = metaData.getTables(null, "ITEMSYS", "ITEMS", types);
            if (rs.next()) {
                System.out.println("✅ Table 'ITEMS' found in schema 'ITEMSYS'");
            } else {
                System.out.println("❌ Table 'ITEMS' not found in schema 'ITEMSYS'");
                
                // Try without schema
                rs = metaData.getTables(null, null, "ITEMS", types);
                if (rs.next()) {
                    System.out.println("✅ Table 'ITEMS' found in current schema");
                }
            }
            rs.close();
            
            // Test data
            testData(conn);
            
        } catch (SQLException e) {
            System.err.println("❌ Connection failed!");
            System.err.println("   Message: " + e.getMessage());
            System.err.println("   SQL State: " + e.getSQLState());
            System.err.println("   Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
    
    private static void testData(Connection conn) {
        System.out.println("\n🔍 Testing data access...");
        
        // Try different table name variations
        String[] queries = {
            "SELECT COUNT(*) FROM items",
            "SELECT COUNT(*) FROM itemSys.items",
            "SELECT COUNT(*) FROM ITEMS",
            "SELECT COUNT(*) FROM ITEMSYS.ITEMS"
        };
        
        for (String query : queries) {
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                
                if (rs.next()) {
                    int count = rs.getInt(1);
                    System.out.println("✅ Query: " + query + " → Count: " + count);
                    
                    // If we found data, show some samples
                    if (count > 0) {
                        showSampleData(conn, query.replace("COUNT(*)", "*").replace("SELECT *", "SELECT * FROM").split(" FROM ")[1].trim() + " WHERE ROWNUM <= 3");
                    }
                    break; // Use first successful query
                }
                
            } catch (SQLException e) {
                System.out.println("❌ Query failed: " + query + " → " + e.getMessage());
            }
        }
    }
    
    private static void showSampleData(Connection conn, String tableName) {
        String query = "SELECT * FROM " + tableName;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            System.out.println("📋 Sample data:");
            while (rs.next()) {
                System.out.println("  ID: " + rs.getInt("id") + 
                                 ", Name: " + rs.getString("name") + 
                                 ", Price: " + rs.getDouble("price") + 
                                 ", Quantity: " + rs.getInt("quantity"));
            }
            
        } catch (SQLException e) {
            System.out.println("❌ Failed to retrieve sample data: " + e.getMessage());
        }
    }
}