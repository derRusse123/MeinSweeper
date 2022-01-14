package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.scene.layout.GridPane;
import model.GameBoard;

public class MatchField {
	private FieldResolver fieldResolver;
	private GameBoardGenerator gameBoardGenerator;
	private Timeline timeline;
	@FXML
	private Button btnRestart;
	@FXML
    private BorderPane borderPane;
	@FXML
	private Button btnStart;
	@FXML
	private Label timerLabel;
	@FXML
	private Label splitTimerLabel;
	@FXML
	private IntegerProperty timeSeconds = new SimpleIntegerProperty();
	
	Duration time = Duration.ZERO;
	GridPane grid;
	
	//We need a model.GameBoard.java...
	private String difficulty;
	private int gameBoardLength;
	private int numberOfBombs;
	
	public void setDifficulty(String dif) {
		difficulty = dif;
	}
	
	public void evaluateDifficulty() {
		//switch case?
		//set gameBoardLength / Number of Bombs
		//make window bigger
		
		gameBoardLength = 15;
		numberOfBombs = 10;
	}
	
	public void initialize() {
	  gameBoardGenerator = new GameBoardGenerator(gameBoardLength, numberOfBombs); //getter-aufruf in GameBoard.java ?
	  grid = new GridPane();
	  borderPane.setCenter(grid);
	  for(int i = 0; i <15; i++) {
		  for(int j = 0; j<15; j++) {
			Button newButton = new Button();
			newButton.setId("Button"+ (i + j*15 +1));
			//ToDo: find a way to make it smaller and still have it showing the value
			newButton.setMinHeight(30);
			newButton.setMaxHeight(30);
			newButton.setMinWidth(30);
			newButton.setMaxWidth(30);
			
			newButton.setOnAction(event -> {
				newButton.setText("-1");
				newButton.setStyle(
						"-fx-background-color: grey;" +
						"" // ToDo: add more styles if needed
						);
				System.out.println(event);
			});
			grid.add(newButton, i, j);
		  }
	  }
	  grid.setAlignment(Pos.CENTER);
	}
    
	public void reset() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/mainpage.fxml"));
		Stage window = (Stage) btnRestart.getScene().getWindow();
		window.setScene(new Scene(root));
	}
    public void handle(Event event) {
		timerLabel.textProperty().bind(timeSeconds.asString());
        timeline = new Timeline(
            new KeyFrame(Duration.millis(1000),
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    Duration duration = ((KeyFrame)t.getSource()).getTime();
                    time = time.add(duration);
                    timeSeconds.set((int) time.toSeconds());
                }
            })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play(); 
}
	
}