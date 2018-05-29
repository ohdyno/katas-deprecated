package me.ohdyno;

import org.approvaltests.Approvals;
import org.junit.Test;

public class WorldTest {
    @Test
    public void nullCellIsConvertedToEmptyCell() {
        World world = new World(null);
        Approvals.verify(world);
    }
}