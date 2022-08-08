package util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    /**
     * Inserts a set of values into given columns of a given table.
     *
     * @param table Name of the table to insert into.
     * @param columnValueMap A HashMap which contains String representations of column names and values.
     */
    public void insert(String table, HashMap<String, String> columnValueMap){

        String[] keys = columnValueMap.keySet().toArray(new String[0]);
        String[] values = columnValueMap.values().toArray(new String[0]);

        String statement = "INSERT INTO " + table + " (" +
                String.join(", ", keys) + ") " + "VALUES ('" +
                String.join("', '", values) + "'" + ");";

        runStatement(statement);
    }

    public void update(String table){
        System.out.println("Updating" + table);
    }

    public void delete(String table){
        System.out.println("Not sure about this one yet");
    }

    /**
     * Creates a where clause given an attribute and a value for comparison.
     *
     * @param attribute Attribute to check.
     * @param value Value to compare attribute to.
     * @return A String representation of a where clause.
     */
    public static String makeWhereClause(String attribute, String value) {
        return String.format("\nWHERE %s = %s", attribute, value);
    }

    /**
     * Gets a JSONArray representation of the query results.
     *
     * @param query String representation of SQL query. Parameterized queries are allowed.
     * @param params An ArrayList of Strings to represent parameters.
     * @return JSONArray
     */
    public static JSONArray getQueryResultsAsJSON(String query, ArrayList<String> params) {
        try (PreparedStatement pStatement = con.prepareStatement(query)){
            for (int q = 0; q < params.size(); q++) {
                pStatement.setString(q + 1, params.get(q));
            }
            try (ResultSet resultSet = pStatement.executeQuery()) {
                return convertResultSetToJSON(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    /**
     * @param rs ResultSet to convert to JSON
     * @return JSONArray
     */
    public static JSONArray convertResultSetToJSON(ResultSet rs) {
        JSONArray json = new JSONArray();
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next()) {
                int numColumns = metaData.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i = 1; i <= numColumns; i++) {
                    String column_name = metaData.getColumnName(i);
                    obj.put(column_name, rs.getObject(column_name));
                }
                json.put(obj);
            }
        } catch (JSONException | SQLException e) {
            e.printStackTrace();
        }
        return json;
    }
}