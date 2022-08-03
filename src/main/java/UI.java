/**
 * UI
 *
 * Implements eager singleton design pattern.
 * There should not be more than one instance of UI.
 *
*/
import java.util.ArrayList;

import org.json.*;

import util.DBConnection;
import util.SQLHelper;


public class UI{

	private static final UI instance = new UI();
	
	private UI() {
	}
	
	private static void displayMenu(){
		System.out.println("Thinking this will be a switch");
	}
	
	public static void main(String[] args){
		System.out.println("Welcome...");
	
        DBConnection dbCon = DBConnection.getInstance();
        
        if (args.length != 3) {
                System.out.println("Incorrect number of arguments. " +
                    "Please provide url, user, password, and driver to access database." +
                    "Exiting now. Please try again.");
            System.exit(1);
        }
        
        String url = args[0];
        String user = args[1];
        String pwd = args[2];
        
        dbCon.setConnection(url, user, pwd);
        
        //  ***** QUERY LOGIC TEST CASES *****
        ArrayList<String> paramX = new ArrayList<String>();
        JSONArray jsonArray = new JSONArray();

/*        // Test listAllEmployeesEverywhere
        JSONArray jsonArray = QueryLogic.queryToJSON(QueryTypes.ALL_EMPLOYEES_INFO, new ArrayList<>());
        System.out.println("All our employees:\n" + jsonArray.toString() + "\n");
        
        
        // Test getAlbumStockAtAllLocations
        paramX.add(0,"Montero");
        jsonArray = QueryLogic.queryToJSON(QueryTypes.ALBUM_INSTOCK_EVERYWHERE,paramX);
        System.out.println("Montero albums\n" + jsonArray + "\n");
        paramX.clear();
        
        // Test artistCollaboration
        paramX.add(0, "Miley Cyrus");
        paramX.add(1, "Lil Nas X");
        jsonArray = QueryLogic.queryToJSON(QueryTypes.ARTIST_COLLABORATION, paramX);
        System.out.println("Miley Cyrus and Lil Nas X:\n" + jsonArray + "\n");
        paramX.clear();
        
        // Test ARTIST_ALBUMS
        paramX.add(0, "Lady Gaga");
        jsonArray = QueryLogic.queryToJSON(QueryTypes.ARTIST_ALBUMS, paramX);
        System.out.println("Lady Gaga\'s Albums: \n" + jsonArray + "\n");
        paramX.clear();
        
        // Test SONG_LYRICS
        paramX.add(0, "room");
        jsonArray = QueryLogic.queryToJSON(QueryTypes.SONG_LYRICS, paramX);
        System.out.println("Lyrics conntaining \'room\': \n" + jsonArray + "\n");
        paramX.clear();
        
     // Test SONG_LYRICS
        paramX.add(0, "You And I");
        jsonArray = QueryLogic.queryToJSON(QueryTypes.ALBUM_SONG_TITLE, paramX);
        System.out.println("Album of the song \'You and I\': \n" + jsonArray + "\n");
        paramX.clear();
        
        // Test SONG_ARTISTS
        paramX.add(0, "Industry Baby");
        jsonArray = QueryLogic.queryToJSON(QueryTypes.SONG_ARTISTS, paramX);
        System.out.println("Arists involved in \'Industry Baby\': \n" + jsonArray + "\n");
        paramX.clear();*/

        // Band Members
        paramX.add("Fleet Foxes");
        String query = SQLHelper.convertScriptToString("scripts/query/BAND_MEMBERS.sql");
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Members of 'Fleet Foxes': \n" + jsonArray + "\n");
        paramX.clear();

        displayMenu();
        dbCon.closeConnection();
	}
}