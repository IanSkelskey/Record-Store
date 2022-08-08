package gui.dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.json.JSONArray;
import util.Query;
import util.SQLHelper;
import java.util.ArrayList;

public class InsertEmployeeDialogController {
    @FXML
    private TextField nameField;

    @FXML
    private ChoiceBox<String> locationChoice;

    public InsertEmployeeDialogController() {

    }

    private ObservableList<String> getAllLocationNames() {
        ObservableList<String> names = FXCollections.observableArrayList();
        JSONArray results = SQLHelper.getQueryResultsAsJSON(Query.LOCATIONS_INFO.query, new ArrayList<>());
        for (int i = 0; i < results.length(); i++) {
            names.add(results.getJSONObject(i).getString("LocationName"));
            System.out.println(results.getJSONObject(i).getString("LocationName"));
        }
        return names;
    }
}
