package org.carbonit.treasurehunt.hexagon.model;

public enum Orientation {
    SOUTH("S"), NORTH("N"), WEST("O"), EAST("E");
    String orientation;

    private Orientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }
}
