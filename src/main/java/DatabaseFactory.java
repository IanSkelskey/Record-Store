/**
* Database Factory
*/
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.io.*;

public class DatabaseFactory {

	private Connection con;

	public DatabaseFactory(String url, String user, String pwd, String driver) {
		try {
			Class.forName(driver);
			this.con = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			System.out.println("Failed to establish connection to database.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Loads a script into a String from a .sql file.
	 * @param filename
	 * @return
	 */
	public String loadScriptFromFile(String filename) {
		String script = "";
		try {
			script = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return script;
	}

	public void create () {
		System.out.println("Creating database");
		String scripts = loadScriptFromFile("scripts/Record-Store_Team_18_create.sql");
		String[] scriptsArray = scripts.split(System.lineSeparator() + System.lineSeparator());
		for (String s : scriptsArray) {
			try (PreparedStatement ps = this.con.prepareStatement(s)){
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printConnectionInfo() {
		try {
			String autoCommit = String.valueOf(this.con.getAutoCommit());
			String catalog = this.con.getCatalog();
			String schema = this.con.getSchema();
			DatabaseMetaData metaData = this.con.getMetaData();

			System.out.println("Connection auto commit status: " + autoCommit);
			System.out.println("Catalog: " + catalog);
			System.out.println("Schema: " + schema);
		} catch (SQLException e) {
			e.printStackTrace();
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

		DatabaseFactory dbFactory = new DatabaseFactory(url, user, pwd, driver);
		dbFactory.printConnectionInfo();
		dbFactory.create();
	}
}