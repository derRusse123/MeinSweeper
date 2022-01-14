package controller;

import model.GameBoard;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class MatchField {
	private GameBoard gameBoard = new GameBoard("Easy", 10, 15); // still weird
	private GameBoardGenerator gameBoardGenerator;
	private FieldResolver fieldResolver;
	
	private Timeline timeline;
	Duration time = Duration.ZERO;
	GridPane grid;
	
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
	
	public void initGamemode(String dif) {
		switch(dif) {
		case "Easy":
			this.gameBoard = new GameBoard(dif, 10, 15);
			break;
		case "Moderate":
			this.gameBoard = new GameBoard(dif, 15, 20);
			break;
		case "Hard":
			this.gameBoard = new GameBoard(dif, 20, 30);
			break;
		}
	}
	
	public void initialize() {
	  gameBoardGenerator = new GameBoardGenerator(gameBoard);
	  grid = new GridPane();
	  borderPane.setCenter(grid);
	  for(int i = 0; i <gameBoard.getGameBoardLength(); i++) {
		  for(int j = 0; j<gameBoard.getGameBoardLength(); j++) {
			Button newButton = new Button();
			newButton.setId("Button"+ (i + j*gameBoard.getGameBoardLength() +1));
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