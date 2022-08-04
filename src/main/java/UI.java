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
		System.out.println("Welcome...");
		
		displayMenu();
}