package gui.dialogs;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class InsertEmployeeDialog extends Dialog<Void> {

    private final Window window = this.getDialogPane().getScene().getWindow();

    public InsertEmployeeDialog() {
        try {
            DialogPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/insert-employee.fxml")));
            ImageView img = new ImageView(Objects.requireNonNull(this.getClass().getResource("/icons/add-emp.png")).toString());
            img.setFitWidth(50);
            img.setFitHeight(50);
            pane.setGraphic(img);
            this.setTitle("Add New Employee");
            this.setDialogPane(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setOnCloseRequest(event -> window.hide());
    }
}
