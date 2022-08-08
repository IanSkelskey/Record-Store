package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.*;

import util.DBConnection;
import util.Query;
import util.SQLHelper;

/**
 * ui.UI
 *
 * The terminal user interface for the record store app.
 */
public class UI {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private UI() {
    }

    private static void showQueryMenu() {
        System.out.println("Welcome to the RSDB query menu.\n");
        int selection;
        while (true) {
            System.out.println("Please enter a selection from the options below.\n");
            for (Query q: Query.values()) {
                System.out.println(q);
            }
            System.out.println("0\t- Exit the application.");
            try {
                selection = Integer.parseInt(in.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("Invalid selection ");
                selection = -1;
            }
            if (selection == 0) { break; }
            else if (selection < 0) { continue; }

            processQueryByType(selection);
        }
    }

    private static void processQueryByType(int type) {
        ArrayList<String> params = new ArrayList<>();
        JSONArray jsonArray;

        Query q = Query.getQueryByID(type);

        System.out.println("You have selected:\n" + q);
        int paramCount = q.paramCount;
        for (int i = 0; i < paramCount; i++) {
            System.out.print("Enter " + q.paramType + ": ");
            String param = null;
            try {
                param = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            params.add(param);
        }
        String query = q.query;

        jsonArray = SQLHelper.getQueryResultsAsJSON(query, params);
        if (jsonArray.length() == 0) {
            System.out.println("Your search returned no results. Please check inputs and try again.");
        } else {
            System.out.println("Result:\n" + jsonArray.toString(2) + "\n");
        }
        System.out.println("Returning to menu...\n");
        params.clear();
    }

    public static void main(String[] args) {

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

        showQueryMenu();
        dbCon.closeConnection();
    }
}