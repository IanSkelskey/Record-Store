import util.DBConnection;
import util.SQLHelper;

/**
 *
 */
public class DBInitializer {

	private static final String SCRIPTS_DIR = "scripts/init/";

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

		SQLHelper.runAllScriptsInDirectory(SCRIPTS_DIR);
		dbCon.closeConnection();
	}
}