/**
 * UI
 *
 * The terminal user interface for the record store app.
 */

import java.util.ArrayList;

import org.json.*;

import util.DBConnection;
import util.QueryLogic;
import util.QueryTypes;
import util.SQLHelper;


public class UI {

    private UI() {
    }

    private static void displayMenu() {
        System.out.println("Thinking this will be a switch");
    }

    public static void main(String[] args) {
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

        // Band Members
        paramX.add("Fleet Foxes");
        String query = SQLHelper.convertScriptToString(QueryTypes.BAND_MEMBERS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Members of 'Fleet Foxes': \n" + jsonArray + "\n");
        paramX.clear();

        // Test artistCollaboration
        paramX.add(0, "Miley Cyrus");
        paramX.add(1, "Lil Nas X");
        query = SQLHelper.convertScriptToString(QueryTypes.ARTIST_COLLABORATION.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Miley Cyrus and Lil Nas X:\n" + jsonArray + "\n");
        paramX.clear();

        // Test SONG_ARTISTS
        paramX.add(0, "Industry Baby");
        query = SQLHelper.convertScriptToString(QueryTypes.SONG_ARTISTS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Arists involved in 'Industry Baby': \n" + jsonArray + "\n");
        paramX.clear();

        // Test SONG_LYRICS
        paramX.add(0, "room");
        query = SQLHelper.convertScriptToString(QueryTypes.SONG_LYRICS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Lyrics conntaining 'room': \n" + jsonArray + "\n");
        paramX.clear();

        // Test ARTIST_ALBUMS
        paramX.add(0, "Lady Gaga");
        query = SQLHelper.convertScriptToString(QueryTypes.ARTIST_ALBUMS.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Lady Gaga's Albums: \n" + jsonArray + "\n");
        paramX.clear();

        // Test getAlbumStockAtAllLocations
        paramX.add(0, "Montero");
        query = SQLHelper.convertScriptToString(QueryTypes.ALBUM_INSTOCK_EVERYWHERE.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Montero albums\n" + jsonArray + "\n");
        paramX.clear();

        // Test ALBUM_SONG_TITLE
        paramX.add(0, "Hair");
        query = SQLHelper.convertScriptToString(QueryTypes.ALBUM_SONG_TITLE.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("The song 'Hair' is found on the album: " + jsonArray + "\n");
        paramX.clear();

        // Test listAllEmployeesEverywhere
        query = SQLHelper.convertScriptToString(QueryTypes.EMPLOYEES_INFO.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, new ArrayList<>());
        System.out.println("All our employees:\n" + jsonArray.toString() + "\n");

        //Test LOCATION_INFO
        query = SQLHelper.convertScriptToString(QueryTypes.LOCATIONS_INFO.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("All location info:\n" + jsonArray + "\n");

        // TEST ALBUM_IN_RANGE
        paramX.add(0, "1970-01-01");
        paramX.add(1, "2016-01-01");
        query = SQLHelper.convertScriptToString(QueryTypes.ALBUMS_IN_RANGE.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("Albums released between '1970-01-01' and '2016-01-01' \n" + jsonArray + "\n");
        paramX.clear();

        // TEST BAND_OF_ARTIST
        paramX.add(0, "Kimberley Ann Deal");
        query = SQLHelper.convertScriptToString(QueryTypes.BAND_OF_ARTIST.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("'Kimberley Ann Deal' was in what band?\n" + jsonArray + "\n");
        paramX.clear();


        // TEST ARTIST_OF_GENRE
        paramX.add(0, "Jazz");
        query = SQLHelper.convertScriptToString(QueryTypes.ALBUMS_OF_GENRE.queryPath);
        jsonArray = QueryLogic.queryToJSON(query, paramX);
        System.out.println("All albums in Jazz genre?\n" + jsonArray + "\n");
        paramX.clear();

        displayMenu();
        dbCon.closeConnection();
    }
}