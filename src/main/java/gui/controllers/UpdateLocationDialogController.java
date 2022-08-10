package gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import util.AttributeGetter;
import util.SQLHelper;

import java.util.Map;

public class UpdateLocationDialogController {
    @FXML
    private DialogPane pane;

    @FXML
    private ChoiceBox<String> locationChoice;

    @FXML
    private ChoiceBox<String> attributesChoice;

    @FXML
    private TextField newValueField;

    public void initialize() {
        populateLocationChoice();
        populateAttributesChoice();
        Button okButton = (Button) pane.lookupButton(ButtonType.OK);
        okButton.addEventFilter(ActionEvent.ACTION, event -> handleOKButton());
    }

    private void handleOKButton () {
        String locationID = AttributeGetter.getLocationIDFromName(locationChoice.getValue());
        SQLHelper.update("Location", attributesChoice.getValue(),
                newValueField.getText(), "LocationID", locationID);
    }

    private void populateAttributesChoice() {
        ObservableList<String> attributes = FXCollections.observableArrayList();
        attributes.addAll(AttributeGetter.getAllModifiableEmployeeAttributes());
        this.attributesChoice.setItems(attributes);
        this.attributesChoice.setValue(attributes.get(0));
    }

    private void populateLocationChoice() {
        ObservableList<String> locations = FXCollections.observableArrayList();
        for (Map.Entry<Integer, String> entry: AttributeGetter.getAllLocationIDsAndNames().entrySet()) {
            locations.add(entry.getValue());
        }
        locationChoice.setItems(locations);
        locationChoice.setValue(locations.get(0));
    }

}
