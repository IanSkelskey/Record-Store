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
import util.QueryTypes;


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
        
        if (args.length != 4) {
                System.out.println("Incorrect number of arguments. " +
                    "Please provide url, user, password, and driver to access database." +
                    "Exiting now. Please try again.");
            System.exit(1);
        }
        
        String url = args[0];
        String user = args[1];
        String pwd = args[2];
        String driver = args[3];
        
        dbCon.setConnection(url, user, pwd, driver);
        
        //  ***** QUERY LOGIC TEST CASES *****
        ArrayList<String> paramX = new ArrayList<String>();
        
        // Test listAllEmployeesEverywhere
        QueryLogic selectable = QueryLogic.getInstance();
        //JSONArray jsonArray = selectable.listAllEmployeesEverywhere();
        JSONArray jsonArray = selectable.queryToJSON(QueryTypes.ALL_EMPLOYEES_INFO, null);
        System.out.println("listAllEmployeesEverywhere():\n" + jsonArray.toString() + "\n");
        
        
        // Test getAlbumStockAtAllLocations
        paramX.add(0,"Montero");
        jsonArray = selectable.queryToJSON(QueryTypes.ALBUM_INSTOCK_EVERYWHERE,paramX);
        System.out.println("getAlbumStockAtAllLocations(\"Montero\")\n" + jsonArray + "\n");
        paramX.clear();
        
        // Test artistCollaboration
        paramX.add(0, "Miley Cyrus");
        paramX.add(1, "Lil Nas X");
        jsonArray = selectable.queryToJSON(QueryTypes.ARTIST_COLLABORATION, paramX);
        System.out.println("artistCollaboration(\"Miley Cyrus\", \"Lil Nas X\"):\n" + jsonArray + "\n");
        
        displayMenu();
        dbCon.closeConnection();
	}
}