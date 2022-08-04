package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class FXMLController {

    private final DBConnection dbCon = DBConnection.getInstance();
    private final ObservableList<Object> data = FXCollections.observableArrayList();
    private final Connection con = dbCon.getConnection();

    @FXML
    private TextArea queryField;

    @FXML
    private ChoiceBox<String> queryChoice;

    @FXML
    private TableView<Object> resultTable;

    public void initialize() {
        populateQueryChoices();
    }

    public void populateQueryChoices() {
        ObservableList<String> choices = FXCollections.observableArrayList();
        choices.add("1");
        choices.add("2");
        choices.add("3");
        choices.add("4");
        queryChoice.setItems(choices);
        queryChoice.setValue("1");
    }


    public void runQueryButtonPressed() {
        clearResults();
        String query = queryField.getText();
        populateResultTable(query);
    }

    public void clearQuery() {
        queryField.clear();
    }

    public void clearResults() {
        data.clear();
        resultTable.getColumns().clear();
        resultTable.getItems().clear();
    }

    public void populateResultTable(String query){

        try (ResultSet rs = con.createStatement().executeQuery(query)) {
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

             // TABLE COLUMN ADDED DYNAMICALLY
            for (int i = 0 ; i < columnCount; i++) {
                String columnName = meta.getColumnName(i + 1);
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(columnName);
                col.setCellValueFactory(
                        (Callback<TableColumn.CellDataFeatures<ObservableList<Object>, String>, ObservableValue<String>>)
                                param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                resultTable.getColumns().add(col);
            }

            // Data added to ObservableList
            while(rs.next()){
                // Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= columnCount; i++){
                    // Iterate Column
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error on populating results table.");
        }

        // Add data to results table
        resultTable.setItems(data);
    }
}