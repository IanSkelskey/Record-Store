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
    private JSONArray jsonResult;
	
	public QueryLogic(){}
	
	public static QueryLogic getInstance() {
	    return qLogic;
	}
	
	public JSONArray getAlbumStockAtAllLocations(String albumTitle){
		String statement = "SELECT \r\n" + 
		        "    inventory.Amount, location.LocationName\r\n" + 
		        "FROM\r\n" + 
		        "    album,\r\n" + 
		        "    inventory,\r\n" + 
		        "    location\r\n" + 
		        "WHERE\r\n" + 
		        "    album.AlbumTitle = ?\r\n" + 
		        "        AND album.AlbumID = inventory.AlbumID\r\n" + 
		        "        AND inventory.LocationID = location.LocationID\r\n" + 
		        "ORDER BY inventory.amount DESC;";
		
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
	    
	    jsonResult = toJSON(resultSet);
	    closeAllResources();
	    
	    return jsonResult;
	}
	
	   public JSONArray artistCollaboration(String artistA, String artistB) {
	        String statement = "SELECT \r\n" + 
	                "    * \r\n" + 
	                "FROM\r\n" + 
	                "    (SELECT \r\n" + 
	                "        song.songTitle\r\n" + 
	                "    FROM\r\n" + 
	                "        song, artist, songfeaturelist\r\n" + 
	                "    WHERE\r\n" + 
	                "        artist.StageName = ?\r\n" + 
	                "            AND artist.ArtistID = songfeaturelist.ArtistID\r\n" + 
	                "            AND songfeaturelist.SongID = song.SongID) AS A\r\n" + 
	                "        JOIN\r\n" + 
	                "    (SELECT \r\n" + 
	                "        song.songTitle\r\n" + 
	                "    FROM\r\n" + 
	                "        song, artist, songfeaturelist\r\n" + 
	                "    WHERE\r\n" + 
	                "        artist.StageName = ?\r\n" + 
	                "            AND artist.ArtistID = songfeaturelist.ArtistID\r\n" + 
	                "            AND songfeaturelist.SongID = song.SongID) AS B ON A.SongTitle = B.songTitle;";
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