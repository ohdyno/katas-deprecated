package me.ohdyno;

import org.approvaltests.Approvals;
import org.junit.Test;

public class GameTest {
    @Test
    public void emptyWorld() {
        World initialWorld = new World();
        Game game = new Game(initialWorld);
        LifeObserver lifeObserver = new LifeObserver();
        game.start(lifeObserver);
        Approvals.verify(lifeObserver.observed());
    }

    @Test
    public void worldWithOneLiveCell() {
        World initialWorld = new World(new LiveCell());
        Game game = new Game(initialWorld);
        LifeObserver lifeObserver = new LifeObserver();
        game.start(lifeObserver);
        Approvals.verify(lifeObserver.observed());
    }

    @Test
    public void worldWithOneDeadCell() {
        World initialWorld = new World(new DeadCell());
        Game game = new Game(initialWorld);
        LifeObserver lifeObserver = new LifeObserver();
        game.start(lifeObserver);
        Approvals.verify(lifeObserver.observed());
    }
}
