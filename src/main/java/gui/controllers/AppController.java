package gui.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;
import util.DialogType;
import util.Query;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Arrays;

public class AppController {

    private final Connection con = DBConnection.getInstance().getConnection();

    @FXML
    private Label resultsInfoLabel;

    @FXML
    private TextField searchBar;

    @FXML
    private ChoiceBox<Query> queryChoice;

    @FXML
    private TableView<Object> resultTable;

    public void initialize() {
        populateQueryChoices();
    }

    public void populateQueryChoices() {
        ObservableList<Query> choices = FXCollections.observableArrayList();
        choices.addAll(Arrays.asList(Query.values()));
        queryChoice.setItems(choices);
        queryChoice.setValue(Query.getQueryByID(1));
    }

    public void clearResults() {
        this.resultsInfoLabel.setText("Awaiting new result set...");
        this.resultTable.getColumns().clear();
        this.resultTable.getItems().clear();
    }

    public void processInputs(String query, String[] params){

        try (PreparedStatement pStatement = this.con.prepareStatement(query)) {
            for (int i = 0; i < this.queryChoice.getValue().paramCount; i++) {
                pStatement.setString(i + 1, params[i]);
            }
            try (ResultSet rs = pStatement.executeQuery()) {
                populateTable(rs);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error on populating results table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error on populating results table.");
        }
    }

    private void populateTable(ResultSet rs) throws SQLException {
        ObservableList<Object> data = FXCollections.observableArrayList();
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            String columnName = meta.getColumnName(i + 1);
            final int j = i;
            TableColumn col = new TableColumn(columnName);
            col.setCellValueFactory(
                    (Callback<TableColumn.CellDataFeatures<ObservableList<Object>, String>, ObservableValue<String>>)
                            param -> new SimpleStringProperty(param.getValue().get(j).toString()));
            this.resultTable.getColumns().add(col);
        }
        while (rs.next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getString(i));
            }
            data.add(row);
        }
        this.resultTable.setItems(data);
    }

    public void openNewEmployeeDialog() {
        DialogType.NEW_EMPLOYEE.show();
    }

    public void openNewLocationDialog() {
        DialogType.NEW_LOCATION.show();
    }

    public void openAboutDialog() {
        DialogType.ABOUT.show();
    }

    public void queryChoiceChanged() {
        if (this.queryChoice.getValue().paramCount == 0) {
            this.searchBar.clear();
            this.searchBar.setEditable(false);
        } else {
            this.searchBar.setEditable(true);
        }
    }

    public void runQueryButtonPressed() {
        clearResults();
        String[] params = this.searchBar.getText().split(",");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }
        String query = this.queryChoice.getValue().query;
        processInputs(query, params);
        this.resultsInfoLabel.setText("Results from: " + this.queryChoice.getValue());
    }

    public void clearButtonPressed() {
        this.searchBar.clear();
    }

    public void openGitRepoInBrowser() {
        Desktop desk = Desktop.getDesktop();
        try {
            desk.browse(new URI("https://github.com/IanSkelskey/Record-Store"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        Stage stage = (Stage) this.resultTable.getScene().getWindow();
        stage.close();
    }
}
