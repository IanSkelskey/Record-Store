package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public enum DialogType {

    ABOUT("About Record Store", "about.fxml"),
    NEW_EMPLOYEE("Add New Employee", "insert-employee.fxml"),
    NEW_LOCATION("Add New Location", "insert-location.fxml");

    public final String title;
    public DialogPane pane = new DialogPane();
    private final String FXMLFileName;

    DialogType(String title, String FXMLFileName) {
        this.title = title;
        this.FXMLFileName = FXMLFileName;
        resetPane();
    }

    private void resetPane() {
        try {
            this.pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/" + this.FXMLFileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        resetPane();
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle(this.title);
        dialog.setDialogPane(this.pane);
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/icons/vinyl.png"))));
        dialog.show();
    }
}
