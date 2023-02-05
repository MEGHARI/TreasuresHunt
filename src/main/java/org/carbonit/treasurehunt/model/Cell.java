package org.carbonit.treasurehunt.model;

import java.util.Objects;

public class Cell {
    private final Position position;
    private boolean free;

    public Cell(boolean free, Position position) {
       this.position = position;
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return free == cell.free && Objects.equals(position, cell.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, free);
    }

    public void setFree(boolean free) {
        this.free = free;
    }



    public boolean isFree() {
        return free;
    }
}
