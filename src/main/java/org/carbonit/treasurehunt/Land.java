package org.carbonit.treasurehunt;

public class Land {

    private final int width;
    private final int height;
    private Adventurer adventurer;

    public Land(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public void withAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
}
