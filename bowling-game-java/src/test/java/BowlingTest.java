import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void returnZeroScoreAtStartOfGame() {
        assertEquals(0, game.score());
    }

    @Test
    public void allGutterBalls_scoreIsZero() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void allRollsOfOne_scoreIsTwenty() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void strikeWithTwoRollsOfOne() {
        game.roll(10);
        game.roll(1);
        game.roll(1);

        assertEquals(14, game.score());
    }

    @Test
    public void strikeAtTheEnd() {
        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(10);
        game.roll(1);
        game.roll(1);

        assertEquals(12, game.score());
    }

    @Test
    public void perfectGame() {
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }
}
