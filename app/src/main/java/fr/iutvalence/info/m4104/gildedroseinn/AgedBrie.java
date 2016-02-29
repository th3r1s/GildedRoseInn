package fr.iutvalence.info.m4104.gildedroseinn;

/**
 * Created by silvesta on 16/02/16.
 */
public class AgedBrie extends Item {

    public AgedBrie( int sellIn, int quality)
    {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateItemQuality() {
        updateAgedBrieItemQuality();
    }

    protected void updateAgedBrieItemQuality()
    {
        incrementItemQualityIfNotFifty();
    }

}
