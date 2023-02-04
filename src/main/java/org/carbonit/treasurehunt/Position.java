package org.carbonit.treasurehunt;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private boolean free;

    public Position(int x, int y, boolean free) {
        this.x = x;
        this.y = y;
        this.free = free;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isFree() {
        return free;
    }
}
