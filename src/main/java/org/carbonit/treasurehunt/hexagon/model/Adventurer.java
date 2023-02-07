package org.carbonit.treasurehunt.hexagon.model;

public class Adventurer {
    private static final Character PROGRESS = 'A';
    private static final Character LEFT_ORIENTATION = 'G';
    private static final Character RIGHT_ORIENTATION = 'D';
    private final String name;
    private Position position;



    private Orientation orientation;
    private int treasure = 0;

    public Adventurer(String name, Position position, Orientation orientation) {
        this.name = name;
        this.position = position;
        this.orientation = orientation;
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
    public void move(Character action) {
        if (PROGRESS == action) {
            progress();
        } else if (LEFT_ORIENTATION == action) {
            leftOrientation();
        } else if (RIGHT_ORIENTATION == action) {
            rightOrientation();
        }
    }


    /**
     * L'orientation droite de l'aventurier.
     */
    private void rightOrientation() {
        Orientation newOrientation = switch (this.orientation) {
            case S -> Orientation.W;
            case N -> Orientation.E;
            case W -> Orientation.N;
            case E -> Orientation.S;
            default -> orientation;
        };
        this.orientation = newOrientation;
    }

    /**
     * L'orientation gauche de l'aventurier.
     */
    private void leftOrientation() {
        Orientation newOrientation = switch (this.orientation) {
            case S -> Orientation.E;
            case N -> Orientation.W;
            case W -> Orientation.S;
            case E -> Orientation.N;
            default -> orientation;
        };
        this.orientation = newOrientation;
    }

    private void progress() {
        Position newPosition = switch (this.orientation) {
            case S -> new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
            case N -> new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
            case W -> new Position(this.getPosition().getX() - 1, this.getPosition().getY());
            case E -> new Position(this.getPosition().getX() + 1, this.getPosition().getY());
            default -> this.getPosition();
        };
        this.setPosition(newPosition);
    }

    public void incrementTreasure() {
        this.treasure++;
    }

    public int getTreasure() {
        return this.treasure;
    }

    public String getName() {
        return name;
    }
    public Orientation getOrientation() {
        return orientation;
    }
}
