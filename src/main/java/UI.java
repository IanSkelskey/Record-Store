/**
 * UI
 *
 * Implements eager singleton design pattern.
 * There should not be more than one instance of UI.
 *
*/

import java.util.HashMap;
import java.util.Map;

import util.DBConnection;
import util.SQLHelper;

public class UI{

	private static final UI instance = new UI();

	private QueryLogic queryLogic;
	private DatabaseUpdater updater;
	
	private UI() {
	    this.queryLogic = new QueryLogic();
	    this.updater = new DatabaseUpdater();
	}
	
	private static void displayMenu(){
		System.out.println("Thinking this will be a switch");
	}
	
	public static void main(String[] args){
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
		System.out.println("Welcome...");
		
		displayMenu();
		
		//Just left this to test the insert method. Will be going before merged into development
		HashMap<String, String> hashInsert = new HashMap<String, String>();
		hashInsert.put("stagename", "\"Ted Nugent\"");
		hashInsert.put("soloflag", "true");
		hashInsert.put("artistname", "\"Ted Nugent\"");
		hashInsert.put("dateofbirth", "\"1945-01-02\"");
		hashInsert.put("bandflag", "false");
		hashInsert.put("established", "\"1945-01-02\"");
		instance.updater.insert("artist", hashInsert);
	}
}