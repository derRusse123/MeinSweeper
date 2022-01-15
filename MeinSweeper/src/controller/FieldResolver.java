package controller;

import javafx.scene.layout.GridPane;
import model.Field;
import model.GameBoard;

public class FieldResolver {
	GameBoard gameBoard;
	MatchField matchField;
	Field[][] fields; //import gameBoard
	int depth;
	int width;
	
	public  FieldResolver(GameBoard gameBoard_, MatchField matchField_){
		gameBoard = gameBoard_;
		fields = gameBoard_.getFields();
		matchField = matchField_;
	}
	
	public void resolveButtonId(int id) {
		depth = (id-1) / gameBoard.getGameBoardLength();
		width = (id-1) % gameBoard.getGameBoardLength();
	}
	
	public void openFieldRecursively(int buttonId){
		resolveButtonId(buttonId);
		switch(fields[depth][width].getValue()) {
			case -1:
				break;
			case 0:
				break;
			default:
				break;
		}
		System.out.println("Button-" + buttonId + " is at i: " + depth + " and j: " + width + " and has value: " + fields[depth][width].getValue()); //debug
	}
	
	public void setButtonValue(int id, int val){
		//kp wie man jetzt den Value settet.... Muss vllt mit return arbeiten
		System.out.println(matchField.grid.getChildren().get(id-1));
	}
	
	public void openField(int buttonId){
		System.out.println(buttonId);
		resolveButtonId(buttonId);
		int fieldValue = fields[depth][width].getValue();
		setButtonValue(buttonId, fieldValue);
		/*
		switch(fieldValue) {
		case -1:
			break;
		case 0:
			break;
		default:
			setButtonValue(buttonId, fieldValue);
			break;
	}
		System.out.println("Button-" + buttonId + " is at i: " + depth + " and j: " + width + " and has value: " + fields[depth][width].getValue()); //debug
*/
	}
}
