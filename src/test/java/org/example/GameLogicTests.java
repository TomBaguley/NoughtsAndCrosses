package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTests {
    GameLogic uut;

    @BeforeEach
    public void setU0() {
        uut = new GameLogic();
    }
    @AfterEach
    public void tearDown() {
        uut = null;
    }
    @Test
    public void testEmptyBoard(){
        String[] row1 = {"-","-","-"};
        String[] row2 = {"-","-","-"};
        String[] row3 = {"-","-","-"};
        boolean expectedOutput = false;
        uut.setGameWon(row1, row2, row3);
        boolean actualOutput = uut.isGameWon();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testXWinner(){
        String[] row1 = {"-","O","X"};
        String[] row2 = {"-","X","O"};
        String[] row3 = {"X","O","-"};
        boolean expectedOutput = true;
        uut.setGameWon(row1, row2, row3);
        boolean actualOutput = uut.isGameWon();
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testRandomCharacters(){
        String[] row1 = {"L","2","z"};
        String[] row2 = {"+"," ","q"};
        String[] row3 = {"0","z","@"};
        boolean expectedOutput = false;
        uut.setGameWon(row1, row2, row3);
        boolean actualOutput = uut.isGameWon();
        assertEquals(expectedOutput,actualOutput);
    }

}
