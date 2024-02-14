package com.priceline.chutes;

import com.priceline.chutes.conventionalgame.BoardSquare;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardSquareTest {

    @Test
    public void aChuteShouldSkipSquaresReversed(){
        BoardSquare square = new BoardSquare(true, false, 10);
        assertTrue(square.getNumberSquaresToSkip() < 0);
    }
}
