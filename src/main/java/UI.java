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
import util.QueryLogic;
import util.QueryTypes;
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

        */

        // Band Members
        paramX.add("Fleet Foxes");
        String[] query = SQLHelper.loadScriptsFromFile(QueryTypes.BAND_MEMBERS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0], paramX);
        System.out.println("Members of 'Fleet Foxes': \n" + jsonArray + "\n");
        paramX.clear();
        query = null;
        
        // Test artistCollaboration
        paramX.add(0, "Miley Cyrus");
        paramX.add(1, "Lil Nas X");
        query = SQLHelper.loadScriptsFromFile(QueryTypes.ARTIST_COLLABORATION.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0], paramX);
        System.out.println("Miley Cyrus and Lil Nas X:\n" + jsonArray + "\n");
        paramX.clear();
        query = null;
        
        // Test SONG_ARTISTS
        paramX.add(0, "Industry Baby");
        query = SQLHelper.loadScriptsFromFile(QueryTypes.SONG_ARTISTS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0], paramX);
        System.out.println("Arists involved in \'Industry Baby\': \n" + jsonArray + "\n");
        paramX.clear();
        query = null;
        
        // Test SONG_LYRICS
        paramX.add(0, "room");
        query = SQLHelper.loadScriptsFromFile(QueryTypes.SONG_LYRICS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0], paramX);
        System.out.println("Lyrics conntaining \'room\': \n" + jsonArray + "\n");
        paramX.clear();
        query = null;
        
        // Test ARTIST_ALBUMS
        paramX.add(0, "Lady Gaga");
        query = SQLHelper.loadScriptsFromFile(QueryTypes.ARTIST_ALBUMS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0], paramX);
        System.out.println("Lady Gaga\'s Albums: \n" + jsonArray + "\n");
        paramX.clear();
        query = null;
        
        
        // Test getAlbumStockAtAllLocations
        paramX.add(0,"Montero");
        query = SQLHelper.loadScriptsFromFile(QueryTypes.ALBUM_INSTOCK_EVERYWHERE.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0],paramX);
        System.out.println("Montero albums\n" + jsonArray + "\n");
        paramX.clear();
        query = null;
        
        // Test ALBUM_SONG_TITLE
        paramX.add(0,"Hair");
        query = SQLHelper.loadScriptsFromFile(QueryTypes.ALBUM_SONG_TITLE.queryPath);
        jsonArray = QueryLogic.queryToJSON(query[0], paramX);
        System.out.println("The song 'Hair' is found on the album: " + jsonArray + "\n");
        paramX.clear();
        query = null;

        displayMenu();
        dbCon.closeConnection();
	}
}