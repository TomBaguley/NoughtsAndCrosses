package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    public boolean gameLegal;
    public boolean gameWon;
    public boolean gameOver;

    public boolean isGameLegal() {
        return gameLegal;
    }

    public void setGameLegal(int userColumn, int userRow, String [] row) {
        if(userRow < 0 || userRow > 3){
            gameLegal = false;
        }
        else if(userColumn < 0 || userColumn > 3){
            gameLegal = false;
        }
        else if(row[userRow - 1].equals("X") || row[userRow - 1].equals("O")){ //Change to user's choice of symbol if added down the line.
            gameLegal = false;
        }
        else{
            gameLegal = true;
        }
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(String [] row1, String [] row2, String [] row3) {
        List<String[]> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        for (String[] r: rowList) {
            if (!r[0].equals("-") && r[0].equals(r[1]) && r[0].equals(r[2])) {
                gameWon = true;
                break;
            }
        }
        for(int i = 0; i < 3; i++) {
            if (!row1[i].equals("-") && row1[i].equals(row2[i]) && row1[i].equals(row3[i])) {
                gameWon = true;
                break;
            }

        }
        if(!row1[0].equals("-") && row1[0].equals(row2[1]) && row1[0].equals(row3[2])){
            gameWon = true;
        }
        else if(!row1[2].equals("-") && row1[2].equals(row2[1]) && row1[2].equals(row3[0])) {
            gameWon = true;
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
