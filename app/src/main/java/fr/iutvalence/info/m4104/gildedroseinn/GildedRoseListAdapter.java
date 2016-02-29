package fr.iutvalence.info.m4104.gildedroseinn;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silvesta on 02/02/16.
 */
public class GildedRoseListAdapter extends BaseAdapter {

    // Une liste de items
    private List<Item> mListP;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public GildedRoseListAdapter(Context context, List<Item> aListP) {
        mContext = context;
        mListP = aListP;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mListP.size();
    }


    @Override
    public Object getItem(int position) {
        return mListP.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.item_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView name = (TextView)layoutItem.findViewById(R.id.name);
        TextView sellin = (TextView)layoutItem.findViewById(R.id.sellin);
        TextView quality = (TextView)layoutItem.findViewById(R.id.quality);

        //(3) : Renseignement des valeurs
        name.setText(mListP.get(position).getName());
        sellin.setText("Sell In: " + String.valueOf(mListP.get(position).getSellIn()));
        quality.setText("Quality: " + String.valueOf(mListP.get(position).getQuality()));

        //On retourne l'item créé.
        return layoutItem;
    }

}
