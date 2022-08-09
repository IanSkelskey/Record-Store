package gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.JSONArray;
import util.Query;
import util.SQLHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InsertEmployeeDialogController {
    @FXML
    private TextField nameField;

    @FXML
    private ChoiceBox<String> locationChoice;

    @FXML
    private DialogPane pane;

    public void initialize() {

        ObservableList<String> locationNames = FXCollections.observableArrayList();
        getAllLocationNamesAndIDs().forEach((key, value) -> {
            locationNames.add(value);
        });
        this.locationChoice.setItems(locationNames);
        this.locationChoice.setValue(locationNames.get(0));

        Button okButton = (Button) pane.lookupButton(ButtonType.OK);
        okButton.addEventFilter(ActionEvent.ACTION, event -> handleOKButton());

    }

    private void handleOKButton () {
        HashMap<String, String> columnValueMap = new HashMap<>();
        columnValueMap.put("Name", nameField.getText());
        for (Map.Entry<Integer, String> entry: getAllLocationNamesAndIDs().entrySet()) {
            if (entry.getValue().equalsIgnoreCase(this.locationChoice.getValue())) {
                columnValueMap.put("LocationID", String.valueOf(entry.getKey()));
            }
        }
        SQLHelper.insert("Employee", columnValueMap);
    }

    private HashMap<Integer, String> getAllLocationNamesAndIDs() {
        HashMap<Integer, String> locationMap = new HashMap<>();
        JSONArray results = SQLHelper.getQueryResultsAsJSON(Query.LOCATIONS_INFO.query, new ArrayList<>());
        for (int i = 0; i < results.length(); i++) {
            int id = results.getJSONObject(i).getInt("LocationID");
            String name = results.getJSONObject(i).getString("LocationName");
            locationMap.put(id, name);
        }
        return locationMap;
    }
}
