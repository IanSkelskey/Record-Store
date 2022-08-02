package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

/**
 * util.SQLHelper
 *
 * This class contains static methods relating to MySQL and JDBC
 */
public class SQLHelper {

    private static final Connection con = DBConnection.getInstance().getConnection();

    /**
     * Private constructor to block instantiation.
     */
    private SQLHelper() {
        throw new IllegalStateException("util.SQLHelper cannot be instantiated.");
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
     */
    public static void runStatements(String[] statements) {
        for (String s : statements) {
            runStatement(s);
        }
    }

    /**
     * Runs a single SQL statement stored in a String.
     *
     * @param statement A String array of SQL statements
     */
    public static void runStatement(String statement) {
        try (CallableStatement cs = con.prepareCall(statement)) {
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs a script from a file given the path.
     *
     * @param path Path for a SQL script
     */
    public static void runScript(String path) {
        String[] scripts = loadScriptsFromFile(path);
        runStatements(scripts);
    }

    /**
     * Runs all SQL scripts in a given directory.
     */
    public static void runAllScriptsInDirectory(String directory) {
        File[] files = new File(directory).listFiles();
        assert files != null;
        for (File f : files) {
            String path = f.getPath();
            runScript(path);
        }
    }
}
