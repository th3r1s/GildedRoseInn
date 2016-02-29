package fr.iutvalence.info.m4104.gildedroseinn;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ShopActivity extends ActionBarActivity {


    private static Money money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_layout);
        if(money == null)
            money = new Money(500);
        displayMoney();

        //Recuperation of the item list
        ArrayList<Item> listP = GildedRose.getItems();

        //Creation and initialization of the Adapter for the items
        GildedRoseListAdapter adapter = new GildedRoseListAdapter(this, listP);

        //Recuperation of the listview component
        final ListView list = (ListView)findViewById(R.id.liste);

        //Initialization of the list with data
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item itemFromList = (Item) list.getItemAtPosition(position);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(),itemFromList.getName() + " has been added to the inventory", duration);
                toast.show();
                InventoryActivity.setItems(itemFromList);
                buyItem(itemFromList);
                displayMoney();
            }
        });
    }

    public static void buyItem(Item item){
        money.subsMoney(item.getSellIn());
    }

    public void displayMoney(){
        TextView textView = (TextView) findViewById(R.id.cash);
        textView.setText("Cash : " + money.getMoney());
    }

    public static Money getMoney() {
        return money;
    }


}
