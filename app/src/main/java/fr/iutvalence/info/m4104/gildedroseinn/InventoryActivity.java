package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class InventoryActivity extends Activity {

    private static ArrayList<Item> items = new ArrayList<Item>();

    private static ArrayList<Item> getItems(){
        return items;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_layout);

        //Creation and initialization of the Adapter for the items
        GildedRoseListAdapter adapter = new GildedRoseListAdapter(this, items);

        //Recuperation of the listview component
        final ListView list = (ListView)findViewById(R.id.listeInventaire);

        //Initialization of the list with data
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item itemFromList = (Item) list.getItemAtPosition(position);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), itemFromList.getName() + " has been used", duration);
                toast.show();
                InventoryActivity.getItems().remove(position);
                list.invalidateViews();
            }
        });
    }


    public static void setItems(Item i){
        items.add(i);
    }


}
