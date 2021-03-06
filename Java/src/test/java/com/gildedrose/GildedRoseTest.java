package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;


class GildedRoseTest {

    @Test
    void updateQualityMethod() {

        /**
         * testing all the possible combinations that could generate bugs: verifyAllCombination method of Approvals tests
         *
         * Elements found with Code Coverage: https://en.wikipedia.org/wiki/Code_coverage
         *  - Name Strings: {"Standard Item", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
         *  - SellIn Integers:  {-1, 0, 10},
         *  - Quality Integers:  {0, 1, 49, 50}
         *
         *  Elements found with Mutation Testing: https://en.wikipedia.org/wiki/Mutation_testing
         *  - SellIn Integers: {3, 8}   --> line 30 and 36 of the GildedRose Assignment
         *
         */
        CombinationApprovals.verifyAllCombinations(this::newItemAndUpdateQuality,
                new String[]{"Standard Item", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "Conjured Water"},
                new Integer[]{-1, 0, 3, 8, 11},
                new Integer[]{0, 1, 49, 50});
    }

    private String newItemAndUpdateQuality(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }


    /**
     *  This test method was meant to start testing before implementing the new Conjured type and before overwriting the ApprovalTests.
     *  After having established the Conjured items were working fine, I added these new coming cases to the ApprovalTests.
     */
//    @Test
//    void updateConjuredQuality(){
//        Item[] conjuredItems = new Item[] {new Item("Conjured Water", 2, 20)};
//        GildedRose app = new GildedRose(conjuredItems);
//        app.updateQuality();
//        assertEquals(18, app.items[0].quality);
//    }

}
