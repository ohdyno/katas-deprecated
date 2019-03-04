package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void characterize() throws Exception {
        final Item item = new Item("af", 2, 4);
        final GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        Approvals.verify(item);
    }
}
