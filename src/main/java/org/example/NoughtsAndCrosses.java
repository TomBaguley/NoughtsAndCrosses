package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NoughtsAndCrosses {
    public static void main(String[] args) {

        Scanner myScanner =  new Scanner(System.in);

        GameLogic gameLogic = new GameLogic();

        Player player1 =  new Player();
        Player player2 = new Player();
        Player leadPlayer =  new Player();
        System.out.println("Player 1, please enter your name");
        player1.setPlayerName(myScanner.nextLine());
        System.out.println("Player 2, please enter your name");
        player2.setPlayerName(myScanner.nextLine());
        player1.setPlayerSymbol("X");
        player2.setPlayerSymbol("O");

        int turnCounter = 1;
        System.out.println(player1.getPlayerName() + ", pick heads or tails to decide who goes first");
        gameLogic.setFlipWon(myScanner.nextLine());
        if(gameLogic.isFlipWon()){
            System.out.println("Congratulations, " + player1.getPlayerName() + "! You go first");
        }
        else{
            System.out.println("Unlucky, " + player1.getPlayerName() + ". " + player2.getPlayerName() + " goes first!");
            turnCounter++;
        }
        Board board1 = new Board();
        gameLogic.setGameWon(board1.getRow1(), board1.getRow2(), board1.getRow3());
        System.out.println(board1);

        while(!gameLogic.gameWon) {
            if(turnCounter % 2 == 1){
                leadPlayer = player1;
            }
            else {
                leadPlayer = player2;
            }
            System.out.println("Please enter the column number followed by the row number. e.g 1,2");
            int userColumn = myScanner.nextInt();
            int userRow = myScanner.nextInt();
            gameLogic.setGameLegal(userColumn, userRow, board1.getRow1(), board1.getRow2(), board1.getRow3());
            if(gameLogic.isGameLegal()) {
                if (userRow == 1) {
                    board1.setRow1(userColumn, leadPlayer.getPlayerSymbol());
                } else if (userRow == 2) {
                    board1.setRow2(userColumn, leadPlayer.getPlayerSymbol());
                } else if (userRow == 3) {
                    board1.setRow3(userColumn, leadPlayer.getPlayerSymbol());
                }
                System.out.println(board1);
                gameLogic.setGameWon(board1.getRow1(), board1.getRow2(), board1.getRow3());
                turnCounter++;
            }
            else{
                System.out.println("Not a valid move");
            }
        }
    }
}