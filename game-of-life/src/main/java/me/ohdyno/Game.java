package me.ohdyno;

class Game {
    private final World initialWorld;

    Game(World initialWorld) {
        this.initialWorld = initialWorld;
    }

    void start(LifeObserver lifeObserver) {
        lifeObserver.observe(initialWorld);
    }
}
