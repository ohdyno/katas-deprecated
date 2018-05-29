package me.ohdyno;

class EmptyCell implements Cell {
    public boolean isLive() {
        return false;
    }

    public boolean isEmpty() {
        return true;
    }
}
