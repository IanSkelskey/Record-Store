/**
* QueryLogic
*/
import java.sql.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.*;

import util.DBConnection;
import util.QueryTypes;

import java.awt.List;
import java.io.*;

public class QueryLogic{
    
    private static final QueryLogic qLogic = new QueryLogic();
    
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private JSONArray jsonResult;
	
	public QueryLogic(){}
	
	public static QueryLogic getInstance() {
	    return qLogic;
	}
	
	public JSONArray getAlbumStockAtAllLocations(String albumTitle){
		String statement = QueryTypes.ALBUM_INSTOCK_EVERYWHERE.query;
		
		try {
		    pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
		    pStatement.setString(1, albumTitle);
		    resultSet = pStatement.executeQuery();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		jsonResult = toJSON(resultSet);
		closeAllResources();
		
		return jsonResult;
	}
	
	public JSONArray listAllEmployeesEverywhere() {
	    String statement = QueryTypes.ALL_EMPLOYEES_INFO.query;
	    try {
            pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
            resultSet = pStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    jsonResult = toJSON(resultSet);
	    closeAllResources();
	    
	    return jsonResult;
	}
	
	   public JSONArray artistCollaboration(String artistA, String artistB) {
	        String statement = QueryTypes.ARTIST_COLLABORATION.query;
	        try {
	            pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
	            pStatement.setString(1, artistA);
	            pStatement.setString(2, artistB);
	            resultSet = pStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        jsonResult = toJSON(resultSet);
	        closeAllResources();
	        
	        return jsonResult;
	    }
	   
	   public JSONArray queryToJSON(QueryTypes type, String[] params) {
	       String statement = type.query;
	       try {
	           pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
	           if (params != null) {
	               for (int q = 0; q < params.length; q++) {
	                   pStatement.setString(q, params[q]);
	               }
	           } else {
	               pStatement = DBConnection.getInstance().getConnection().prepareStatement(statement);
	               resultSet = pStatement.executeQuery();
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       
	       jsonResult = toJSON(resultSet);
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
            //if (DBConnection.getInstance().getConnection() != null) DBConnection.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}