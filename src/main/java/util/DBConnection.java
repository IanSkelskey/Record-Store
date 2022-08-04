package util;

import java.sql.*;

public class DBConnection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final DBConnection connectionInstance = new DBConnection();
    private Connection dbConnection = null;

    private DBConnection() {}

    public static DBConnection getInstance() {
        return connectionInstance;
    }
    
    public void setConnection(String url, String user, String password) {
        if (dbConnection != null) {
            System.out.println("Cannot set connection more than once during runtime.");
            return;
        }
        try {
            Class.forName(DRIVER);
            dbConnection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
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
