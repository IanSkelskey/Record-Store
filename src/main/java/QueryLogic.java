/**
* QueryLogic
*/
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.*;

import util.DBConnection;
import util.QueryTypes;

import java.awt.List;
import java.io.*;

public class QueryLogic{
    
    private static final QueryLogic qLogic = new QueryLogic();
    
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
       
       jsonResult = toJSON(resultSet);
       closeAllResources();
       
       return jsonResult;
   }
	
	// FROM: https://www.baeldung.com/java-jdbc-convert-resultset-to-json
	public static JSONArray toJSON(ResultSet resultSet) {
	    JSONArray jsonResult = null;
	    try {
	        ResultSetMetaData md = resultSet.getMetaData();
	        int numCols = md.getColumnCount();
	        java.util.List<String> colNames = IntStream.range(0, numCols)
	          .mapToObj(i -> {
	              try {
	                  return md.getColumnName(i + 1);
	              } catch (SQLException e) {
	                  e.printStackTrace();
	                  return "?";
	              }
	          })
	          .collect(Collectors.toList());

	        jsonResult = new JSONArray();
	        while (resultSet.next()) {
	            JSONObject row = new JSONObject();
	            colNames.forEach(cn -> {
	                try {
	                    row.put(cn, resultSet.getObject(cn));
	                } catch (JSONException | SQLException e) {
	                    e.printStackTrace();
	                }
	            });
	            jsonResult.put(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return jsonResult;
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