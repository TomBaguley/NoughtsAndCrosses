package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NoughtsAndCrosses {
    public static void main(String[] args) {
        Player player1 =  new Player();
        Player player2 = new Player();
        Board board1 = new Board();
        Scanner myScanner =  new Scanner(System.in);
        GameLogic gameLogic = new GameLogic();
        gameLogic.setGameWon(board1.getRow1(), board1.getRow2(), board1.getRow3());
        System.out.println(gameLogic.isGameWon());
        System.out.println(board1);
        while(!gameLogic.gameWon) {
            System.out.println("Please enter the column number followed by the row number. e.g 1,2");
            int userColumn = myScanner.nextInt();
            int userRow = myScanner.nextInt();
            gameLogic.setGameLegal(userColumn, userRow, board1.getRow1());
            if(gameLogic.isGameLegal()) {
                if (userRow == 1) {
                    board1.setRow1(userColumn, "X");
                } else if (userRow == 2) {
                    board1.setRow2(userColumn, "X");
                } else if (userRow == 3) {
                    board1.setRow3(userColumn, "X");
                }
                System.out.println(board1);
                gameLogic.setGameWon(board1.getRow1(), board1.getRow2(), board1.getRow3());
                System.out.println(gameLogic.isGameWon());
            }
            else{
                System.out.println("Not a valid move");
            }
        }
    }
}