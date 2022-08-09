package gui.dialogs;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class DeleteAlbumDialog extends Dialog<Void> {
	
	private final Window window = this.getDialogPane().getScene().getWindow();
	
	public DeleteAlbumDialog() {
		try {
			DialogPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/delete-album.fxml")));
            this.setTitle("Delete album");
			this.setDialogPane(pane);
		}catch(IOException e){
			e.printStackTrace();
		}
		window.setOnCloseRequest(event -> window.hide());
	}
}