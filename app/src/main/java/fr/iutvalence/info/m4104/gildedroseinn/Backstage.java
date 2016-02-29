package fr.iutvalence.info.m4104.gildedroseinn;

/**
 * Created by silvesta on 16/02/16.
 */
public class Backstage extends Item{

    private static final int SELL_IN_DATE_THRESHOLD_FOR_BACKSTAGE_QUALITY_BEING_DECREMENTED_THREE_TIMES = 5;
    private static final int SELL_IN_DATE_THRESHOLD_FOR_BACKSTAGE_QUALITY_BEING_DECREMENTED_TWICE = 10;

    public Backstage(int sellIn, int quality){
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void updateItemQuality()
    {
        updateBackstageItemQuality();
    }

    private void updateBackstageItemQuality()
    {
        if (hasItemSellInDatePassed())
        {
            setQuality(0);
            return;
        }

        decrementItemQualityIfNotZero();
        if (getSellIn() <= SELL_IN_DATE_THRESHOLD_FOR_BACKSTAGE_QUALITY_BEING_DECREMENTED_TWICE)
            decrementItemQualityIfNotZero();
        if (getSellIn() <= SELL_IN_DATE_THRESHOLD_FOR_BACKSTAGE_QUALITY_BEING_DECREMENTED_THREE_TIMES)
            decrementItemQualityIfNotZero();
    }
}
