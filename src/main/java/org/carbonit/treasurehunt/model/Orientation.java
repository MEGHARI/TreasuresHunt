package org.carbonit.treasurehunt.model;

public enum Orientation {
    SOUTH("S");
    String south;

    private Orientation(String s) {
        this.south = s;
    }

    public String getOrientation() {
        return south;
    }
}
