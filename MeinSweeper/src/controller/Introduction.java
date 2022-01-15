package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Introduction {
	@FXML
	private Button btnCloseIntro;
	
	@FXML
	private BorderPane bpIntro;
	
	Stage stage;
	
	public void closeIntro(ActionEvent e) {
		stage = (Stage) bpIntro.getScene().getWindow();
		stage.close();
	}
}
