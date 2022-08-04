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
     * Loads a master script into a String from a .sql file.
     *
     * @param filename The filename of the .sql script
     * @return scripts An array of individual SQL statements
     */
    public static String convertScriptToString(String filename) {
        String script = "";
        Path filePath = Paths.get(filename);
        try {
            script = new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return script;
    }

    /**
     * @param multiStatement
     *  A SQL script stored in a string that contains multiple statements separated by a semicolon
     * @return An array of strings where each element contains one statement.
     */
    public static String[] splitMultiStatement(String multiStatement) {
        return multiStatement.split(";");
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
     * Cannot be used to run SELECT statements.
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
        String multiScript = convertScriptToString(path);
        String[] scripts = splitMultiStatement(multiScript);
        runStatements(scripts);
    }

    /**
     * Runs all SQL scripts in a given directory.
     * If the scripts must be run in a particular order,
     * name each script with a leading number to indicate its position in line.
     *
     * For Example:
     *  - 0_drop.sql
     *  - 1_create.sql
     *  - 2_insert.sql
     *  - 3_lyrics.sql
     */
    public static void runAllScriptsInDirectory(String directory) {
        File[] files = new File(directory).listFiles();
        assert files != null;
        for (File f : files) {
            String path = f.getPath();
            runScript(path);
        }
    }

    /**
     * Counts all parameters in a SQL script. Parameters are represented by
     * question marks (?). Make sure that there are no comments in the script that contain
     * question mark characters.
     *
     * @param script A String representation of a parameterized SQL script.
     * @return The number of parameters.
     */
    public static int countScriptParameters(String script) {
        int count = 0;
        for (int i = 0; i < script.length(); i++) {
            if(script.charAt(i) == '?') {
                count++;
            }
        }
        return count;
    }
}
