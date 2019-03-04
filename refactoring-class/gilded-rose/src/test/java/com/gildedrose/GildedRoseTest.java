package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void characterize() throws Exception {
        CombinationApprovals.verifyAllCombinations(this::processInput, new String[]{"Aged Brie", "Sulfuras, Hand of Ragnaros", "", "hello My name is Lana and I am a cute puppy dog",
                        "Backstage passes to a TAFKAL80ETC concert"},
                new Integer[]{2, 4, 0, -1, 10, 55, 7}, new Integer[]{4, 2, 0, -3000, 10, 55});
    }

    private Item processInput(String name, int sellln, int quality) {
        final Item item = new Item(name, sellln, quality);
        final GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        return item;
    }
}
