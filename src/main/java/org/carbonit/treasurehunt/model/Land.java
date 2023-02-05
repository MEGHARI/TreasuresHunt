package org.carbonit.treasurehunt.model;

public class Land {

    private final int horizontalCellsNumber;
    private final int verticalCellsNumber;
    private Cell[][] cells;


    public Land(int horizontalCellsNumber, int verticalCellsNumber) {

        this.horizontalCellsNumber = horizontalCellsNumber;
        this.verticalCellsNumber = verticalCellsNumber;
        init();
    }

    private void init() {
        cells = new Cell[horizontalCellsNumber][verticalCellsNumber];
        for (int x = 0; x < horizontalCellsNumber; x++) {
            for (int y = 0; y < verticalCellsNumber; y++) {
                cells[x][y] = new Cell(true, new Position(x, y));
            }
        }
    }

    public void addAdventurer(Adventurer adventurer) {
        cells[adventurer.getPosition().getX()][adventurer.getPosition().getX()].setFree(false);
    }


    public boolean isValidateLocation(Adventurer adventurer) {

        return adventurer.isConsistentPosition(horizontalCellsNumber, verticalCellsNumber)
                &&
                cells[adventurer.getPosition().getX()][adventurer.getPosition().getY()].isFree();
    }

    public Cell[][] getCells() {
        return cells;
    }

}
