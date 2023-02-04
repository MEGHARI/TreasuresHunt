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


    public boolean isValidateLocation(Adventurer adventurer) {
        Position positionAdventurer = adventurer.position();
        return positionAdventurer.getX() >= 0
                && positionAdventurer.getY() >=0
                && positionAdventurer.getX() < horizontalCellsNumber
                && positionAdventurer.getY() < verticalCellsNumber;
    }
}
