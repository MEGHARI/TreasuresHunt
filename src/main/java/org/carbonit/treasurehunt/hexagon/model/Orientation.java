package org.carbonit.treasurehunt.hexagon.model;

public enum Orientation {
    S("SOUTH"), N("NORTH"), W("WEST"), E("EAST");
    String orientation;

    private Orientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }
}
