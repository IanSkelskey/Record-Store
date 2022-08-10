package gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import org.json.JSONArray;
import util.Query;
import util.SQLHelper;

import java.util.ArrayList;

public class UpdateLocationDialogController {
    @FXML
    private DialogPane pane;

    @FXML
    private ChoiceBox<String> employeeChoice;

    @FXML
    private ChoiceBox<String> attributesChoice;

    public void initialize() {
        populateAttributesChoice();
        Button okButton = (Button) pane.lookupButton(ButtonType.OK);
        okButton.addEventFilter(ActionEvent.ACTION, event -> handleOKButton());
    }

    private void handleOKButton () {

    }

    public void populateAttributesChoice() {
        ObservableList<String> attributes = FXCollections.observableArrayList();
        attributes.addAll(getAllModifiableEmployeeAttributes());
        this.attributesChoice.setItems(attributes);
    }

    private ArrayList<String> getAllModifiableEmployeeAttributes() {
        JSONArray results = SQLHelper.getQueryResultsAsJSON(Query.EMPLOYEES_INFO.query, new ArrayList<>());
        return new ArrayList<>(results.getJSONObject(0).keySet());
    }

}
