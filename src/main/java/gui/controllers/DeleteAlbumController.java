package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import util.SQLHelper;

public class DeleteAlbumController {
	
	@FXML
	private TextField albumField;
	
	@FXML
	private DialogPane deletepane;
	
	public void initialize() {
		Button okButton = (Button)deletepane.lookupButton(ButtonType.OK);
		okButton.addEventFilter(ActionEvent.ACTION, event -> handleOkButton());
	}
	
	public void handleOkButton(){
		SQLHelper.delete("Album", "albumtitle", albumField.getText());
	}
	
}