package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    public boolean gameLegal;
    public boolean gameWon;
    public boolean gameOver;
    public boolean flipWon;

    public boolean isFlipWon() {
        return flipWon;
    }

    public void setFlipWon(String userChoice) {
        boolean validChoice = false;
        while (!validChoice) {
            int rand = 0;
            if (userChoice.equalsIgnoreCase("heads") || userChoice.equalsIgnoreCase("tails")) {
                validChoice = true;
                rand = (int) (Math.random() * 2) + 1;
            } else {
                System.out.println("Not a valid side, please try again");
                Scanner myScanner = new Scanner(System.in);
                userChoice = myScanner.nextLine();

            }
            if(rand == 1){
                System.out.println("Heads!");
            }
            else{
                System.out.println("Tails!");
            }
            if ((userChoice.equalsIgnoreCase("heads") && rand == 1) || (userChoice.equalsIgnoreCase("tails") && rand == 2)){
                flipWon = true;
            }
            else{
                flipWon = false;
            }
        }
    }

    public boolean isGameLegal() {
        return gameLegal;
    }

    public void setGameLegal(int userColumn, int userRow, String[] row) {
        if (userRow < 0 || userRow > 3) {
            gameLegal = false;
        } else //Change to user's choice of symbol if added down the line.
            if (userColumn < 0 || userColumn > 3) {
                gameLegal = false;
            } else gameLegal = !row[userRow - 1].equals("X") && !row[userRow - 1].equals("O");
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(String[] row1, String[] row2, String[] row3) {
        List<String[]> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        for (String[] r : rowList) {
            if (!r[0].equals("-") && r[0].equals(r[1]) && r[0].equals(r[2])) {
                gameWon = true;
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!row1[i].equals("-") && row1[i].equals(row2[i]) && row1[i].equals(row3[i])) {
                gameWon = true;
                break;
            }

        }
        if (!row1[0].equals("-") && row1[0].equals(row2[1]) && row1[0].equals(row3[2])) {
            gameWon = true;
        } else if (!row1[2].equals("-") && row1[2].equals(row2[1]) && row1[2].equals(row3[0])) {
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
