package view;
	
import java.io.IOException;

import controller.GameBoardGenerator;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/mainpage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		//primaryStage.getIcons().add(new Image("windowlogo.jpg"));
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(event -> {
			event.consume();
			quitGame(primaryStage);
		});
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void quitGame(Stage stage) {
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Logout");
	alert.setHeaderText("You're about to quit the game!");
	alert.setContentText("If you want to quit, press OK.");
			
	if(alert.showAndWait().get() == ButtonType.OK) {
		stage.close();
	}
}
}
