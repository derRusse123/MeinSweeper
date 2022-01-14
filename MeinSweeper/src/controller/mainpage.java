package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class mainpage implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
	private MatchField matchField = new MatchField();
	private ObservableList<String> oList = FXCollections.observableArrayList(getList());
	@FXML
	private Button btnQuit;	
	@FXML
	private Button btnIntro;	
	@FXML
	private Button btnStart;	
	@FXML
	private BorderPane bpMainpage;	
	@FXML
	private ChoiceBox<String> choiceBoxDif;
	
	public ArrayList<String> getList(){
		ArrayList<String> entries = new ArrayList <String>();
		String dif1 = "Easy";
		String dif2 = "Moderate";
		String dif3 = "Hard";
		entries.add(dif1);
		entries.add(dif2);
		entries.add(dif3);
		return entries;
	}
	
	public void initialize(URL url, ResourceBundle rn) {
		choiceBoxDif.getItems().addAll(oList);
		choiceBoxDif.getSelectionModel().select(0); //sets Easy to default
	}
	
	public void difChanged() { // gets called onChange
		matchField.initGamemode(choiceBoxDif.getSelectionModel().getSelectedItem());
	}
	
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
		matchField = fxmlLoader.<MatchField>getController();
		Stage window = (Stage) btnStart.getScene().getWindow();
		Scene matchFieldScene = new Scene(root);
		matchFieldScene.getStylesheets().add(getClass().getResource("/view/matchfield.css").toExternalForm());
		window.setScene(matchFieldScene);
	}
	
}
