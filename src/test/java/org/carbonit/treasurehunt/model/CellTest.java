package org.carbonit.treasurehunt.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void shouldInitCellWithTwoTreasures() {
        // GIVEN
        int numberTreasure = 2;
        Position position = new Position(1,2);
        //WHEN
        Cell cell = new Cell(true,position,numberTreasure);
        //THEN
        Assertions.assertEquals(cell.getTreasure(),2);
    }

    @Test
    public void shouldSoustrateOneTresorToCell1_2() {
        // GIVEN
        int numberTreasure = 2;
        Position position = new Position(1,2);
        //WHEN
        Cell cell = new Cell(true,position,numberTreasure);
        cell.setTreasure(cell.getTreasure()-1);
        //THEN
        Assertions.assertEquals(cell.getTreasure(),1);
    }
}
