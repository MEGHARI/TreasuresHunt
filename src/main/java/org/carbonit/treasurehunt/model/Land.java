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
                cells[x][y] = new Cell(true, new Position(x, y),0);
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

    public void moveAdventurerInLand(Adventurer adventurer, String movingSequences) {
        for (int i = 0; i < movingSequences.length(); i++) {
            Position oldPositionOfAdventurer = new Position(adventurer.getPosition().getX(), adventurer.getPosition().getY());
            adventurer.move(movingSequences.charAt(i));
            if (!isValidateLocation(adventurer)) {
                adventurer.setPosition(oldPositionOfAdventurer);

            } else {
                if (this.getCells()[adventurer.getPosition().getX()][adventurer.getPosition().getY()].getTreasure() > 0) {
                    adventurer.incrementTreasure();
                }
            }
            updateStateCells(adventurer,oldPositionOfAdventurer);
        }


    }

    private void updateStateCells(Adventurer adventurer, Position oldPositionOfAdventurer) {
        if (!adventurer.getPosition().equals(oldPositionOfAdventurer)) {
            this.getCells()[adventurer.getPosition().getX()][adventurer.getPosition().getY()].setFree(false);
            this.getCells()[adventurer.getPosition().getX()][adventurer.getPosition().getY()].substractTreasure();
            this.getCells()[oldPositionOfAdventurer.getX()][oldPositionOfAdventurer.getY()].setFree(true);
        }
    }


    public Cell[][] getCells() {
        return cells;
    }

    public void addMountain(Position mountain) {
        cells[mountain.getX()][mountain.getY()].setFree(false);
    }
}
