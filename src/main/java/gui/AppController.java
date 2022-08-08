package gui;

import gui.dialogs.AboutDialog;
import gui.dialogs.InsertEmployeeDialog;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import util.DBConnection;
import util.Query;

import java.sql.*;
import java.util.Arrays;

public class AppController {

    private final DBConnection dbCon = DBConnection.getInstance();
    private final ObservableList<Object> data = FXCollections.observableArrayList();
    private final Connection con = dbCon.getConnection();

    @FXML
    private Label tableHeader;

    @FXML
    private TextField searchBar;

    @FXML
    private ChoiceBox<Query> queryChoice;

    @FXML
    private TableView<Object> resultTable;

    public void initialize() {
        populateQueryChoices();
    }

    public void openNewEmployeeDialog() {
        InsertEmployeeDialog dialog = new InsertEmployeeDialog();
        dialog.show();
    }

    public void populateQueryChoices() {
        ObservableList<Query> choices = FXCollections.observableArrayList();
        choices.addAll(Arrays.asList(Query.values()));
        queryChoice.setItems(choices);
        queryChoice.setValue(Query.getQueryByID(1));
    }

    public void runQueryButtonPressed() {
        clearResults();
        String[] params = searchBar.getText().split(",");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }
        String query = queryChoice.getValue().query;
        processInputs(query, params);
        tableHeader.setText("Results from: " + queryChoice.getValue());
    }

    public void clearResults() {
        this.data.clear();
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
            this.data.add(row);
        }
        this.resultTable.setItems(this.data);
    }

    public void openAboutDialog() {
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.show();
    }

    public void close() {
        Stage stage = (Stage) this.resultTable.getScene().getWindow();
        stage.close();
    }

}
