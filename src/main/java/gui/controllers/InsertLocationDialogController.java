package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.SQLHelper;

import java.util.HashMap;

public class InsertLocationDialogController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private DialogPane pane;

    public void initialize() {
        Button okButton = (Button) pane.lookupButton(ButtonType.OK);
        okButton.addEventFilter(ActionEvent.ACTION, event -> handleOKButton());
    }

    private void handleOKButton () {
        HashMap<String, String> columnValueMap = new HashMap<>();
        columnValueMap.put("LocationName", nameField.getText());
        columnValueMap.put("Address", addressField.getText());
        columnValueMap.put("PhoneNumber", phoneField.getText());
        SQLHelper.insert("Location", columnValueMap);
    }


}
