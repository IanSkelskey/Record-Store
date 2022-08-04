package util;

import java.sql.*;
import java.util.ArrayList;
import org.json.*;

/**
 * QueryLogic
 */
public class QueryLogic{

    private static final Connection DBCon = DBConnection.getInstance().getConnection();
    
    private QueryLogic(){}
    
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