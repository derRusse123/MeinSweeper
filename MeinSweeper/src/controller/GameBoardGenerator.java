package controller;

import model.Field;

public class GameBoardGenerator {
  int gameBoardLength;
  int numberOfBombs;
  Field gameBoard[][];
  
public GameBoardGenerator(int gameBoardLength_,int numberOfBombs_){
  this.gameBoardLength = gameBoardLength_;
  this.numberOfBombs = numberOfBombs_;
  gameBoard = new Field[this.gameBoardLength][this.gameBoardLength];
  //generate gameBoard
  for(int i = 0; i< this.gameBoardLength; i++) {
    for(int j = 0; j< this.gameBoardLength; j++) {
      Field newField = new Field(0);
      gameBoard[i][j] = newField;
    }
  }
  
  //fill with bombs
  for(int i = 0; i<this.numberOfBombs; i++) {
    int xValue = getRandomNumber(0,this.numberOfBombs);
    int yValue = getRandomNumber(0,this.numberOfBombs);
    if(gameBoard[xValue][yValue].getValue() != -1) {
      gameBoard[xValue][yValue].setValue(-1);
    }
  }
  
  //set numbers around bombs
  for(int i = 0; i< this.gameBoardLength; i++) {
    for(int j = 0; j< this.gameBoardLength; j++) {
      if(gameBoard[i][j].getValue() != -1) {
        if(i != 0 && gameBoard[i-1][j].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(i != this.gameBoardLength-1 && gameBoard[i+1][j].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(j != 0 && gameBoard[i][j-1].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(j != this.gameBoardLength-1 && gameBoard[i][j+1].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(i != 0 && j != 0 && gameBoard[i-1][j-1].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(i != 0 && j!= this.gameBoardLength-1 && gameBoard[i-1][j+1].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(i != this.gameBoardLength-1 && j != 0 && gameBoard[i+1][j-1].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      
        if(i != this.gameBoardLength-1 && j != this.gameBoardLength-1 && gameBoard[i+1][j+1].getValue() == -1) {
          gameBoard[i][j].incrementValue();
        }
      }
    }
    
  }
  showTable();

  }
  
  public int getRandomNumber(int min, int max) {
      return (int)((Math.random()*(max-min))+min);
  }
  
  void showTable() {
    for(int i = 0; i< this.gameBoardLength; i++) {
      for(int j = 0; j< this.gameBoardLength; j++) {
        System.out.print("[" + gameBoard[i][j].getValue() + "]");
      } 
      System.out.println("");
    }
    
  }
}