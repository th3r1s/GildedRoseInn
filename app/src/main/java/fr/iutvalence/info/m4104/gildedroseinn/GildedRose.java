package fr.iutvalence.info.m4104.gildedroseinn;

import java.util.ArrayList;

public class GildedRose
{
    private static ArrayList<Item> items;
    public static int day = 0;

    public static ArrayList<Item> getItems(){
        if(items == null){
            items = new ArrayList<Item>();
            items.add(new Item("+5 Dexterity Vest", 10, 20));
            items.add(new Item("Aged Brie", 2, 0));
            items.add(new Item("Elixir of the Mongoose", 5, 7));
            items.add(new Sulfuras(0, 80));
            items.add(new Sulfuras(-1, 80));
            items.add(new Backstage(15, 20));
            items.add(new Backstage(10, 49));
            items.add(new Backstage(5, 49));
            items.add(new Item("Conjured Mana Cake", 3, 6));
        }
        return items;
    }

    public static void updateItems(){
        for(Item item : getItems()){
            item.updateItem();
        }
    }

}

