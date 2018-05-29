package me.ohdyno;

class DeadCell implements Cell {
    public boolean isLive() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }
}
