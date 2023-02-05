package org.carbonit.treasurehunt.model;

public class Adventurer {
    private static final Character PROGRESS = 'A';
    private static final Character LEFT_ORIENTATION = 'G';
    private static final Character RIGHT_ORIENTATION = 'D';
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


    /**
     * Methode qui permet à l'aventurier de se deplacer à l'interieur de la carte fournie.
     */
    public void move() {
        for (int i = 0; i < this.movingSuquences.length(); i++) {
            if (PROGRESS == movingSuquences.charAt(i)) {
                Position newPosition = switch (this.orientation) {
                    case SOUTH -> new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
                    case NORTH -> new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
                    case WEST -> new Position(this.getPosition().getX() - 1, this.getPosition().getY());
                    case EAST -> new Position(this.getPosition().getX() + 1, this.getPosition().getY());
                    default -> this.getPosition();
                };
                this.setPosition(newPosition);
            } else if (LEFT_ORIENTATION == movingSuquences.charAt(i)) {
                Orientation newOrientation = switch (this.orientation) {
                    case SOUTH -> Orientation.EAST;
                    case NORTH -> Orientation.WEST;
                    case WEST -> Orientation.SOUTH;
                    case EAST -> Orientation.NORTH;
                };
                this.orientation = newOrientation;
            } else if (RIGHT_ORIENTATION == movingSuquences.charAt(i)) {
                Orientation newOrientation = switch (this.orientation) {
                    case SOUTH -> Orientation.WEST;
                    case NORTH -> Orientation.EAST;
                    case WEST -> Orientation.NORTH;
                    case EAST -> Orientation.SOUTH;
                };
                this.orientation = newOrientation;
            }
        }

    }
}
