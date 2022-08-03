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

    public void printConnectionInfo() {
        try {
            String autoCommit = String.valueOf(dbConnection.getAutoCommit());
            String catalog = dbConnection.getCatalog();
            String schema = dbConnection.getSchema();
            System.out.println("Connection auto commit status: " + autoCommit);
            System.out.println("Catalog: " + catalog);
            System.out.println("Schema: " + schema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printDatabaseMetaData() {
        try {
            DatabaseMetaData meta = dbConnection.getMetaData();
            String activeCatalog = dbConnection.getCatalog();

            System.out.println("Database product name: " + meta.getDatabaseProductName());
            System.out.println("Database product version: " + meta.getDatabaseProductVersion());
            System.out.println();

            System.out.println("Supports batch updates? " + meta.supportsBatchUpdates());

            System.out.println("Table Names and their Columns in Active Catalog (" + activeCatalog + "):");
            ResultSet tableSet = meta.getTables(activeCatalog, null, "%", new String[]{"TABLE"});
            while(tableSet.next()) {
                String tableName = tableSet.getString(3);
                System.out.println(tableName);
                ResultSet columnSet = meta.getColumns(activeCatalog, null, tableName, "%");
                while(columnSet.next()) {
                    String columnName = columnSet.getString(4);
                    System.out.println("\t" + columnName);
                }
                System.out.println();
            }
            System.out.println();

            ResultSet catalogs = meta.getCatalogs();
            System.out.println("Available Catalogs: ");
            while (catalogs.next()) {
                System.out.println(catalogs.getString("TABLE_CAT").toLowerCase());
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
