import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

/**
 * SQLHelper
 *
 * This class contains static methods relating to MySQL and JDBC
 */
public class SQLHelper {

    /**
     * Private constructor to block instantiation.
     */
    private SQLHelper() {
        throw new IllegalStateException("SQLHelper cannot be instantiated.");
    }

    /**
     * Loads a master script into a String array of individual scripts from a .sql file.
     * This method assumes that SQL statements are separated by a semicolon.
     * Excess white space at the end of scripts will produce unexpected results.
     *
     * @param filename The filename of the .sql script
     * @return scripts An array of individual SQL statements
     */
    public static String[] loadScriptsFromFile(String filename) {
        String masterScript = "";
        Path filePath = Paths.get(filename);
        try {
            masterScript = new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterScript.split(";");
    }

    /**
     * Runs a set of SQL statements stored in a String array.
     *
     * @param statements A String array of SQL statements
     * @param con The MySQL database connection
     */
    public static void runStatements(String[] statements, Connection con) {
        for (String s : statements) {
            try (CallableStatement cs = con.prepareCall(s)) {
                cs.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
