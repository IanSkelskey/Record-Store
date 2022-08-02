/**
 * UI
 *
 * Implements eager singleton design pattern.
 * There should not be more than one instance of UI.
 *
*/
import org.json.*;

import util.DBConnection;


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
        
        QueryLogic selectable = QueryLogic.getInstance();
        JSONArray jsonArray = selectable.listAllEmployeesEverywhere();
        System.out.println(jsonArray.toString());
        
        displayMenu();
	}
}