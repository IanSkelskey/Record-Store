/**
* Database Factory
*/
import java.sql.*;

public class TableLoader {

	private Connection con;

	public TableLoader(String url, String user, String pwd, String driver) {
		try {
			Class.forName(driver);
			this.con = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			System.out.println("Failed to establish connection to database.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void createTables() {
		String[] scripts = SQLHelper.loadScriptsFromFile("scripts/Record-Store_Team_18_create.sql");
		SQLHelper.runScripts(scripts, this.con);
	}

	public void populateTables() {
		String[] inserts = SQLHelper.loadScriptsFromFile("scripts/Record-Store_Team_18_insert.sql");
		SQLHelper.runScripts(inserts, this.con);

		String[] lyrics = SQLHelper.loadScriptsFromFile("scripts/Record-Store_Team_18_update_lyrics.sql");
		SQLHelper.runScripts(lyrics, this.con);
	}


	public static void main(String[] args){
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

		TableLoader tableLoader = new TableLoader(url, user, pwd, driver);
		tableLoader.createTables();
		tableLoader.populateTables();
	}
}