package me.ohdyno;

import static java.util.Objects.requireNonNullElseGet;

class World {
    private final Cell cell;

    public String toString() {
        if (cell.isEmpty()) {
            return "World{}";
        }

        if (cell.isLive()) {
            return "World{x}";
        }

        return "World{-}";
    }

    public World(Cell cell) {
        this.cell = requireNonNullElseGet(cell, EmptyCell::new);
    }

    public World() {
        this(new EmptyCell());
    }

}
