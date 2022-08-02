
import java.sql.*;

public class RSConnection {
    
    private static RSConnection connectionInstance = new RSConnection();
    private RSConnection() {};
    
    private Connection dbConnection;
    
    public static RSConnection getInstance() {
        return connectionInstance;
    }
    
    public void setConnection(String url, String user, String password, String driver) {
        try {
            Class.forName(driver);
            dbConnection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };
    
    public Connection getConnection() {
        return this.dbConnection;
    }
    
    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
