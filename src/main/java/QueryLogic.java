/**
* QueryLogic
*/
import java.sql.*;
import java.util.ArrayList;

import org.json.*;

import util.DBConnection;
import util.QueryTypes;

public class QueryLogic{
    
    private static PreparedStatement pStatement;
    private static ResultSet resultSet;
    private static JSONArray jsonResult;
    
    private QueryLogic(){}
    
   public static JSONArray queryToJSON(QueryTypes type, ArrayList<String> params) {
       String statement = type.query;
       try {
           pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
           if (params != null) {
               for (int q = 0; q < params.size(); q++) {
                   pStatement.setString(q+1, params.get(q));
               }
           } else {
               pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
               resultSet = pStatement.executeQuery();
           }
           resultSet = pStatement.executeQuery();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       jsonResult = altJSON(resultSet);
       closeAllResources();
       
       return jsonResult;
   }
	
	public static JSONArray altJSON(ResultSet rs) {
	    JSONArray json = new JSONArray();
	    
	    try {
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()) {
              int numColumns = rsmd.getColumnCount();
              JSONObject obj = new JSONObject();
              for (int i=1; i<=numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
              }
              json.put(obj);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    return json;
	}
	
	public static void closeAllResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (pStatement != null) pStatement.close();
            //if (DBConnection.getInstance().getConnection() != null) DBConnection.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}