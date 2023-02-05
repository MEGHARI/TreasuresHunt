package org.carbonit.treasurehunt.model;

public class Adventurer {
    private final String name;
    private Position position;
    private Orientation orientation;
    private final String movingSuquences;

    public Adventurer(String name, Position position, Orientation orientation, String movingSuquences) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
        this.movingSuquences = movingSuquences;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
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

    public void move() {
        if ("A".equals(this.movingSuquences)) {
            Position newPosition = switch (this.getOrientation()) {
                case SOUTH -> new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
                case NORTH -> new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
                case OUEST -> new Position(this.getPosition().getX() - 1, this.getPosition().getY());
                case EAST -> new Position(this.getPosition().getX() + 1, this.getPosition().getY());
                default -> this.getPosition();
            };
            this.setPosition(newPosition);
        }

    }
}
