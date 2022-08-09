package gui.dialogs;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class AboutDialog extends Dialog<Void> {

    private final Window window = this.getDialogPane().getScene().getWindow();

    public AboutDialog() {
        try {
            DialogPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/about.fxml")));
            ImageView img = new ImageView(Objects.requireNonNull(this.getClass().getResource("/icons/vinyl.png")).toString());
            img.setFitWidth(128);
            img.setFitHeight(128);
            img.setSmooth(true);
            pane.setGraphic(img);
            this.setTitle("About Record Store");
            this.setDialogPane(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setOnCloseRequest(event -> window.hide());
    }



}
