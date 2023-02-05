package org.carbonit.treasurehunt.model;

public class Adventurer {
    private final String name;
    private Position position;
    private Orientation orientation;
    private String movingSuquences;
    public Adventurer(String name, Position position, Orientation orientation, String movingSuquences) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.movingSuquences = "";
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


    public Orientation getOrientation() {
        return orientation;
    }
}
