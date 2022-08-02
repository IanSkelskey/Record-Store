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
    
    private static final QueryLogic qLogic = new QueryLogic();
    
    private PreparedStatement pStatement;
    private ResultSet resultSet;
	
	public QueryLogic(){}
	
	public static QueryLogic getInstance() {
	    return qLogic;
	}
	
	public void getAlbumStockAtAllLocations(String albumTitle){
		System.out.println("Thinking this will print a list of availability by location");
		
		closeAllResources();
	}
	
	public JSONArray listAllEmployeesEverywhere() {
	    String statement = "SELECT \r\n" + 
	            "    employee.EmployeeID, employee.Name, location.LocationName\r\n" + 
	            "FROM\r\n" + 
	            "    employee,\r\n" + 
	            "    location\r\n" + 
	            "WHERE\r\n" + 
	            "    employee.EmployeeID = location.LocationID\r\n" + 
	            "ORDER BY location.LocationID;";
	    try {
            pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
            resultSet = pStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    JSONArray jsonResult = toJSON(resultSet);
	    closeAllResources();
	    
	    return jsonResult;
	}
	
	// FROM: https://www.baeldung.com/java-jdbc-convert-resultset-to-json
	public JSONArray toJSON(ResultSet resultSet) {
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
	
	public void closeAllResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (pStatement != null) pStatement.close();
            if (DBConnection.getInstance().getConnection() != null) DBConnection.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}