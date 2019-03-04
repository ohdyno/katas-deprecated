package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE)) {
                handleAgedBrie(item);
                continue;
            }
            if (item.name.equals(BACKSTAGE_PASSES)) {
                handleBackstagePasses(item);
                continue;
            }
            if (item.name.equals(SULFURAS)) {
                continue;
            }
            handleOthers(item);
        }
    }

    private void handleOthers(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality--;
            }
        }
    }

    private void handleBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality++;

        }

        item.sellIn--;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality++;
            }
        }
    }

}