package fr.iutvalence.info.m4104.gildedroseinn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class HomeActivity extends Activity {


    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        TimerTask myTask = new TimerTask() {            //TimerTask : a day is passed
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        nextDay();
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(myTask, 0, 10000);              //Delay = 10 seconds
    }
    public void homeActivityClickListener(View view)
    {
        switch (view.getId())
        {
            case R.id.shop_button :
                startShopActivity();
                break;
            case R.id.inventory_button :
                startInventoryActivity();
                break;
            case R.id.next_button :
                nextDay();
                break;
            case R.id.addCash :
                ShopActivity.getMoney().addMoney(50);       //Add 50 to the cash
            default :
        }
    }



    private void nextDay()
    {
        GildedRose.day++;
        TextView textView = (TextView) findViewById(R.id.day_text);
        textView.setText("Day " + GildedRose.day);
        GildedRose.updateItems();
    }

    private void startInventoryActivity()
    {
        this.startActivity(new Intent(this, InventoryActivity.class));
    }

    private void startShopActivity()
    {
        this.startActivity(new Intent(this, ShopActivity.class));
    }

}
