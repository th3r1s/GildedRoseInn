package fr.iutvalence.info.m4104.gildedroseinn;

public class Item {
    protected final String name;

	protected int sellIn;

	protected int quality;

	public Item(String name, int sellIn, int quality)
	{
		this.name = name;
		this.sellIn = sellIn;
		this.setQuality(quality);
	}

	public String getName()
	{
		return this.name;
	}

	public void setSellIn(int sellIn)
	{
		this.sellIn = sellIn;
	}

	public int getSellIn()
	{
		return this.sellIn;
	}

	public int getQuality()
	{
		return quality;
	}

	public void setQuality(int quality)
	{
		this.quality = quality;
	}

	public void updateItem()
	{
		updateItemQuality();
		updateItemSellIn();
	}

	protected void updateItemSellIn()
	{
		decrementItemSellIn();
	}

	protected void updateItemQuality()
	{
		updateNormalItemQuality();
	}



	protected void updateNormalItemQuality()
	{
		decrementItemQualityIfNotZero();
		if (hasItemSellInDatePassed())
			decrementItemQualityIfNotZero();
	}

	protected void incrementItemQualityIfNotFifty()
	{
		if (getQuality() < 50)
			incrementItemQuality();
	}

	protected void incrementItemQuality()
	{
		setQuality(getQuality() + 1);
	}

	protected void decrementItemQualityIfNotZero()
	{
		if (getQuality() > 0)
			decrementItemQuality();
	}

	protected boolean hasItemSellInDatePassed()
	{
		return getSellIn() <= 0;
	}

	protected void decrementItemSellIn()
	{
		setSellIn(getSellIn() - 1);
	}

	protected void decrementItemQuality()
	{
		setQuality(getQuality() - 1);
	}

	public String toString(){
		return name+"\nSellIn : "+sellIn+"\nQuality : "+quality;
	}





}

