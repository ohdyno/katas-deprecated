package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void characterize() throws Exception {
        String[] names = new String[]{"any item", "something new", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", null};
        Integer[] sellins = new Integer[]{1, 10, -1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        Integer[] qualities = new Integer[]{1, 50, 51, 49, 0, -1, Integer.MAX_VALUE, Integer.MIN_VALUE};

        CombinationApprovals.verifyAllCombinations(this::runTest, names, sellins, qualities);
    }

    private Item runTest(String any_item, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(any_item, sellIn, quality)};
        GildedRose testSubject = new GildedRose(items);
        testSubject.updateQuality();
        return items[0];
    }
}
