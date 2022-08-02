import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseInfo {

    public static void printConnectionInfo(Connection con) {
        try {
            String autoCommit = String.valueOf(con.getAutoCommit());
            String catalog = con.getCatalog();
            String schema = con.getSchema();
            System.out.println("Connection auto commit status: " + autoCommit);
            System.out.println("Catalog: " + catalog);
            System.out.println("Schema: " + schema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printDatabaseMetaData(Connection con) {
        try {
            DatabaseMetaData meta = con.getMetaData();
            String activeCatalog = con.getCatalog();

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
