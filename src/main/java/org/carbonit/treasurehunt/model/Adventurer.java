package org.carbonit.treasurehunt.model;

public class Adventurer {
    private final String name;
    private Position position;
    private final String orientation;
    public Adventurer(String name, Position position, String orientation) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isConsistentPosition(int horizontalCellsNumber, int verticalCellsNumber) {
        return this.position.getX() >= 0
                && this.position.getY() >= 0
                && this.position.getX() < horizontalCellsNumber
                && this.position.getY() < verticalCellsNumber;
    }


    public String getOrientation() {
        return orientation;
    }
}
