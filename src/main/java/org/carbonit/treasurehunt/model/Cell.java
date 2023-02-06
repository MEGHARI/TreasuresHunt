package org.carbonit.treasurehunt.model;

import java.util.Objects;

public class Cell {
    private final Position position;
    private boolean isFree;
    private int treasure;

    public Cell(boolean isFree, Position position, int treasure) {
        this.position = position;
        this.isFree = isFree;
        this.treasure = treasure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return isFree == cell.isFree && Objects.equals(position, cell.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, isFree);
    }

    public void setFree(boolean free) {
        this.isFree = free;
    }



    public boolean isFree() {
        return isFree;
    }

    public int getTreasure() {
        return treasure;
    }
}
