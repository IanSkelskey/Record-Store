/**
* Database Factory
*/
import java.io.File;
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

	public void runScript(String path) {
		String[] scripts = SQLHelper.loadScriptsFromFile(path);
		SQLHelper.runStatements(scripts, this.con);
	}

	public void runAllScripts() {
		File[] files = new File("scripts/init/").listFiles();
		assert files != null;
		for (File f : files) {
			String path = f.getPath();
			runScript(path);
		}
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
		tableLoader.runAllScripts();
	}
}