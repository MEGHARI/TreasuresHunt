package org.carbonit.treasurehunt;

public class Land {

    private final int horizontalCellsNumber;
    private final int verticalCellsNumber;
    private Adventurer adventurer;
    private Position[][] cells;

    public Land(int horizontalCellsNumber, int verticalCellsNumber) {

        this.horizontalCellsNumber = horizontalCellsNumber;
        this.verticalCellsNumber = verticalCellsNumber;
        init();
    }

    private void init() {
        cells = new Position[horizontalCellsNumber][verticalCellsNumber];
        for (int x = 0; x < horizontalCellsNumber; x++) {
            for (int y = 0; y < verticalCellsNumber; y++) {
                cells[x][y] = new Position(x, y, true);
            }
        }
    }

    public void withAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
        cells[adventurer.getPosition().getX()][adventurer.getPosition().getX()].setFree(false);
    }


    public boolean isValidateLocation(Adventurer adventurer) {

        return adventurer.isConsistentPosition(horizontalCellsNumber, verticalCellsNumber)
                &&
                cells[adventurer.getPosition().getX()][adventurer.getPosition().getY()].isFree();
    }

}
