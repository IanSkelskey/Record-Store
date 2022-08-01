import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class SQLHelper {
    /**
     * Loads a master script into a String array of individual scripts from a .sql file.
     * This method assumes that SQL statements are separated by an empty line. Failure to adhere
     * to this standard will produce unexpected results.
     * @param filename The filename of the .sql script
     * @return scripts An array of individual SQL statements
     */
    public static String[] loadScriptsFromFile(String filename) {
        String masterScript = "";
        try {
            masterScript = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterScript.split(System.lineSeparator() + System.lineSeparator());
    }

    public static void printConnectionInfo(Connection con) {
        try {
            String autoCommit = String.valueOf(con.getAutoCommit());
            String catalog = con.getCatalog();
            String schema = con.getSchema();
            DatabaseMetaData metaData = con.getMetaData();

            System.out.println("Connection auto commit status: " + autoCommit);
            System.out.println("Catalog: " + catalog);
            System.out.println("Schema: " + schema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
