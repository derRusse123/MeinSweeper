package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainpage {
	@FXML
	private Button btnQuit;
	
	@FXML
	private Button btnIntro;
	
	@FXML
	private Button btnStart;
	
	@FXML
	private BorderPane bpMainpage;
	
	@FXML
	private ChoiceBox choiceBoxDif;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void getIntroduction(ActionEvent e) throws IOException {
		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/view/introduction.fxml"));
		Parent intro = (Parent) fxmlloader.load();
		Stage stage = new Stage();
		stage.setTitle("Introduction");
		stage.setScene(new Scene(intro));
		stage.show();
	}
	
	public void quitGame(ActionEvent e) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Closing window");
		alert.setHeaderText("You're about to close the game!");
		alert.setContentText("If you want to quit, press OK.");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) bpMainpage.getScene().getWindow();
			stage.close();
		}
	}
	
	public void startGame() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/matchfield.fxml"));
		
		Parent root = (Parent)fxmlLoader.load();
		MatchField matchField = fxmlLoader.<MatchField>getController();
		matchField.setDifficulty("Easy"); //ToDo: Make that value dynamic
		Stage window = (Stage) btnStart.getScene().getWindow();
		Scene matchFieldScene = new Scene(root);
		matchFieldScene.getStylesheets().add(getClass().getResource("/view/matchfield.css").toExternalForm());
		window.setScene(matchFieldScene);
	}
	
}
