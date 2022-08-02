/**
* QueryLogic
*/
import java.sql.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.*;

import util.DBConnection;

import java.awt.List;
import java.io.*;

public class QueryLogic{
    
    private PreparedStatement pStatement;
    private ResultSet resultSet;
	
	public QueryLogic(){
		
	}
	
	public void getAlbumStockAtAllLocations(String albumTitle){
		System.out.println("Thinking this will print a list of availability by location");
		
		closeAllResources();
	}
	
	public ResultSet listAllEmployeesEverywhere() {
	    return resultSet;
	}
	
	public JSONArray toJSON() {
	    JSONArray result = null;
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

	        result = new JSONArray();
	        while (resultSet.next()) {
	            JSONObject row = new JSONObject();
	            colNames.forEach(cn -> {
	                try {
	                    row.put(cn, resultSet.getObject(cn));
	                } catch (JSONException | SQLException e) {
	                    e.printStackTrace();
	                }
	            });
	            result.put(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    
	    return result;
	}
	
	private void closeAllResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (pStatement != null) pStatement.close();
            if (DBConnection.getInstance().getConnection() != null) DBConnection.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}