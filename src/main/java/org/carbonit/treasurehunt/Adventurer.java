package org.carbonit.treasurehunt;

public class Adventurer {
    private final String name;
    private Position position;

    public Adventurer(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isConsistentPosition(int horizontalCellsNumber, int verticalCellsNumber) {
        return this.position.getX() >= 0
                && this.position.getY() >= 0
                && this.position.getX() < horizontalCellsNumber
                && this.position.getY() < verticalCellsNumber;
    }
}
