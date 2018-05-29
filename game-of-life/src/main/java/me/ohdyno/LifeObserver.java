package me.ohdyno;

class LifeObserver {
    private World world;

    World observed() {
        return world;
    }

    void observe(World world) {
        this.world = world;
    }
}
