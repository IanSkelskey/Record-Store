package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.DBConnection;

import java.io.IOException;
import java.util.Objects;

public class GUI extends Application {

    private static final DBConnection dbCon = DBConnection.getInstance();

    public static void main(String[] args) {

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

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox root = null;

        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/record-store.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert root != null;
        Scene scene = new Scene(root);
        primaryStage.setTitle("Record Store");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}