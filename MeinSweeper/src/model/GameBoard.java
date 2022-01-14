package model;

public class GameBoard {
	private String difficulty;
	private int gameBoardLength;
	private int numberOfBombs;
	private Field fields[][];
	
	public GameBoard(String dif, int len, int bombs) {
		difficulty = dif;
		gameBoardLength = len;
		numberOfBombs = bombs;
	}
	
	public GameBoard getGameBoard() {
		return this;
	}
	
	public void setFields(Field fields_[][]){
		fields = fields_;
	}
	
	public Field[][] getFields(){
		return fields;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String difficulty_) {
		difficulty = difficulty_;
	}
	public int getGameBoardLength() {
		return gameBoardLength;
	}
	
	public void setGameBoardLength(int len) {
		gameBoardLength = len;
	}
	
	public int getNumberOfBombs() {
		return numberOfBombs;
	}
	
	public void setNumberOfBombs(int number) {
		numberOfBombs = number;
	}
}
