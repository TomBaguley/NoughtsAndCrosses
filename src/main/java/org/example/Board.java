package org.example;

import java.util.Arrays;
import java.util.Arrays.*;

public class Board {
    private String [] row1 = {"-","-","-"};
    private String [] row2 = {"-","-","-"};
    private String [] row3 = {"-","-","-"};
    @Override
    public String toString() {
        String formattedRow1 = Arrays.toString(row1).replace(",","");
        String formattedRow2 = Arrays.toString(row2).replace(",","").replace("[","|").replace("]","|");
        String formattedRow3 = Arrays.toString(row3).replace(",","");

        return formattedRow1 + '\n' + formattedRow2 + '\n' + formattedRow3;
    }
}
