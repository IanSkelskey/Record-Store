package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
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
        setStage(primaryStage);
        primaryStage.show();
        bringStageToFront(primaryStage);
    }

    private void setStage(Stage stage) {
        try {
            BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/record-store.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinWidth(root.getPrefWidth());
            stage.setMinHeight(root.getPrefHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/icons/vinyl.png"))));
        stage.setTitle("Record Store Database Application");
    }

    private void bringStageToFront(Stage stage) {
        stage.setAlwaysOnTop(true);
        stage.setAlwaysOnTop(false);
    }
}