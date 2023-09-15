package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NoughtsAndCrosses {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        GameLogic gameLogic = new GameLogic();

        Player player1 = new Player();
        Player player2 = new Player();
        Player leadPlayer = new Player();
        System.out.println("Player 1, please enter your name");
        player1.setPlayerName(myScanner.nextLine());
        System.out.println("Player 2, please enter your name");
        player2.setPlayerName(myScanner.nextLine());

        System.out.println("Would you like to pick custom symbols? y/n");

        if (myScanner.nextLine().equalsIgnoreCase("y") || myScanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println(player1.getPlayerName() + ", please pick a symbol:");
            String custom1 = myScanner.nextLine();
            boolean validSymbol1 = false;

            while (!validSymbol1) {

                if (custom1.length() != 1) {
                    System.out.println("Symbol must be 1 character, enter another symbol");
                } else if (custom1.equals("-") || custom1.equals(",") || custom1.equals("[")
                        || custom1.equals("]") || custom1.equals("|")) {
                    System.out.println("Invalid symbol, please enter another");
                } else {
                    validSymbol1 = true;
                }
            }
            player1.setPlayerSymbol(custom1);

            System.out.println(player2.getPlayerName() + ", please pick a symbol:");
            String custom2 = myScanner.nextLine();
            boolean validSymbol2 = false;

            while (!validSymbol2) {

                if (custom2.length() != 1) {
                    System.out.println("Symbol must be 1 character, enter another symbol");
                } else if (custom2.equals("-") || custom2.equals(",") || custom2.equals("[")
                        || custom2.equals("]") || custom2.equals("|")) {
                    System.out.println("Invalid symbol, please enter another");
                } else if (custom2.equals(custom1)) {
                    System.out.println("Symbol cannot be the same as" + player1.getPlayerName() + "'s, please enter another symbol");
                } else {
                    validSymbol2 = true;
                }
            }
            player2.setPlayerSymbol(custom2);
        } else {
            player1.setPlayerSymbol("X");
            player2.setPlayerSymbol("O");
        }
        player1.setPlayerScore(0);
        player2.setPlayerScore(0);
        gameLogic.gameOver = false;
        while (!gameLogic.gameOver) {
            int turnCounter = 1;
            System.out.println(player1.getPlayerName() + ", pick heads or tails to decide who goes first");
            gameLogic.setFlipWon(myScanner.nextLine());
            if (gameLogic.isFlipWon()) {
                System.out.println("Congratulations, " + player1.getPlayerName() + "! You go first");
            } else {
                System.out.println("Unlucky, " + player1.getPlayerName() + ". " + player2.getPlayerName() + " goes first!");
                turnCounter++;
            }
            Board board1 = new Board();
            gameLogic.setGameWon(board1.getRow1(), board1.getRow2(), board1.getRow3());
            System.out.println(board1);

            while (!gameLogic.gameWon) {
                if (turnCounter % 2 == 1) {
                    leadPlayer = player1;
                } else {
                    leadPlayer = player2;
                }
                System.out.println(leadPlayer.getPlayerName() + ", please enter the column number followed by the row number. e.g 1,2");
                int userColumn = myScanner.nextInt();
                int userRow = myScanner.nextInt();
                gameLogic.setGameLegal(userColumn, userRow, board1.getRow1(), board1.getRow2(), board1.getRow3(),
                        player1.getPlayerSymbol(), player2.getPlayerSymbol());
                if (!gameLogic.gameLegal) {
                    System.out.println("Not a legal move");
                } else {
                    if (userRow == 1) {
                        board1.setRow1(userColumn, leadPlayer.getPlayerSymbol());
                    } else if (userRow == 2) {
                        board1.setRow2(userColumn, leadPlayer.getPlayerSymbol());
                    } else if (userRow == 3) {
                        board1.setRow3(userColumn, leadPlayer.getPlayerSymbol());
                    }
                    System.out.println(board1);
                    turnCounter++;
                    gameLogic.setBoardFull(board1.getRow1(), board1.getRow2(), board1.getRow3());
                    System.out.println(gameLogic.boardFull);
                    gameLogic.setGameWon(board1.getRow1(), board1.getRow2(), board1.getRow3());
                    if (gameLogic.isBoardFull() && !gameLogic.isGameWon()) {
                        System.out.println("Draw!");
                        System.out.println("Scores: " + player1.getPlayerName() + ": " + player1.getPlayerScore() + " " +
                                player2.getPlayerName() + ": " + player2.getPlayerScore());
                        break;
                    } else if (gameLogic.isGameWon()) {
                        System.out.println("Congratulations, " + leadPlayer.getPlayerName() + "! You Won!");
                        leadPlayer.setPlayerScore(leadPlayer.getPlayerScore()+1);
                        System.out.println("Scores: " + player1.getPlayerName() + ": " + player1.getPlayerScore() + " " +
                                player2.getPlayerName() + ": " + player2.getPlayerScore());
                    }

                }
            }
            System.out.println("Would you like to play again? y/n");
            myScanner.nextLine();
            String playAgain = myScanner.nextLine();
            if(playAgain.equalsIgnoreCase("y") || playAgain.equalsIgnoreCase("yes")){
                gameLogic.gameOver = false;
            }
            else if(playAgain.equalsIgnoreCase("n") || playAgain.equalsIgnoreCase("no")){
                gameLogic.gameOver = true;
            }
        }
    }
}