package org.carbonit.treasurehunt.model;

public enum Orientation {
    SOUTH("S"), NORTH("N"), OUEST("O"), EAST("E");
    String orientation;

    private Orientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }
}