package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void characterize() throws Exception {
        CombinationApprovals.verifyAllCombinations(this::processInput, new String[]{"af"}, new Integer[]{2}, new Integer[]{4});
    }

    private Item processInput(String name, int sellln, int quality) {
        final Item item = new Item(name, sellln, quality);
        final GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        return item;
    }
}
