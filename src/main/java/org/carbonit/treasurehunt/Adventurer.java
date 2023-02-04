package org.carbonit.treasurehunt;

public class Adventurer {
    private final String name;
    private int x;
    private int y;

    public Adventurer(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Position position() {
        return new Position(1, 1);
    }
}
