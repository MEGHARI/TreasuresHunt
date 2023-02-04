package org.carbonit.treasurehunt;

public class Land {

    private final int horizontalCellsNumber;
    private final int verticalCellsNumber;
    private Adventurer adventurer;

    public Land(int horizontalCellsNumber, int verticalCellsNumber) {

        this.horizontalCellsNumber = horizontalCellsNumber;
        this.verticalCellsNumber = verticalCellsNumber;
    }

    public void withAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
        //
    }


    public boolean isInside(Adventurer adventurer) {
        return true;
    }
}
