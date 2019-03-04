package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void characterize() throws Exception {
        final Item item = new Item("af", 2, 4);
        Approvals.verify(item);
    }
}
