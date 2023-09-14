package org.example;

import java.util.Arrays;
import java.util.Arrays.*;

public class Board {
    private String [] row3 = {"-","-","-"};
    private String [] row2 = {"-","-","-"};
    private String [] row1 = {"-","-","-"};

    public String[] getRow1() {
        return row1;
    }

    public void setRow1(int input, String replacement) {
        row1[input-1] = replacement;
    }

    public String[] getRow2() {
        return row2;
    }

    public void setRow2(int input, String replacement) {
        row2[input-1] = replacement;
    }

    public String[] getRow3() {
        return row3;
    }

    public void setRow3(int input, String replacement) {
        row3[input-1] = replacement;
    }

    @Override
    public String toString() {
        String columnNumbers = (" 1 2 3 ");
        String formattedRow3 = Arrays.toString(row3).replace(",","");
        String formattedRow2 = Arrays.toString(row2).replace(",","").replace("[","|").replace("]","|");
        String formattedRow1 = Arrays.toString(row1).replace(",","");

        return formattedRow3 + "3" + '\n' + formattedRow2 + "2" + '\n' + formattedRow1 + "1" + '\n' + columnNumbers;
    }
}
