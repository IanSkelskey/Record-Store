package util;

import java.sql.*;
import java.util.ArrayList;
import org.json.*;

/**
 * Static Util class to dynamically handle sql queries and return the result set records
 * @author Nathanael & Ian
 *
 */
public class QueryLogic{

    private static final Connection DBCon = DBConnection.getInstance().getConnection();
    
    private QueryLogic(){}
    
    /**
     *  
     * @param query is the String representation of the sql query.
     * @param params is the set of Strings that hold the sql parameters to handle dynamic
     * queries
     * @return pStatement is the JSONArray that represents the result set records
     */
    public static JSONArray queryToJSON(String query, ArrayList<String> params) {
        try (PreparedStatement pStatement = DBCon.prepareStatement(query)){
            for (int q = 0; q < params.size(); q++) {
                pStatement.setString(q + 1, params.get(q));
            }
            try (ResultSet resultSet = pStatement.executeQuery()) {
                return altJSON(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
   }

   /**
    * This method is written so that Result Sets are not passed around.
    * Instead query results are translated into JSONArrays that other methods
    * and classes can use.
    * @param rs is the result set object passed in
    * @return json is a JSONArray representation of the result set
    */
	public static JSONArray altJSON(ResultSet rs) {
	    JSONArray json = new JSONArray();
	    try {
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()) {
              int numColumns = rsmd.getColumnCount();
              JSONObject obj = new JSONObject();
              for (int i = 1; i <= numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
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