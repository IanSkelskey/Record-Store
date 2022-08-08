package gui;

import javafx.scene.control.Dialog;
import javafx.stage.Window;

public class NewEmployeeDialog extends Dialog<Void> {

    private final Window window = this.getDialogPane().getScene().getWindow();

    NewEmployeeDialog() {
        this.setTitle("Add New Employee");
        window.setOnCloseRequest(event -> window.hide());
    }

}
