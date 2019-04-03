package com.example.myapplication.part3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

public class itemAdapter extends BaseAdapter {

    private String[] items;
    private String[] descriptions;
    private String[] prices;
    private LayoutInflater inflater;

    public itemAdapter(Context c, String[] i, String[] d, String[] p) {
        super();
        items = i;
        descriptions = d;
        prices = p;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = (View)inflater.inflate(R.layout.activity_part3_view, null);
        ((TextView)v.findViewById(R.id.part3_listViewItem_Item)).setText(items[position]);
        ((TextView)v.findViewById(R.id.part3_listViewitem_description)).setText(descriptions[position]);
        ((TextView)v.findViewById(R.id.part3_listViewitem_price)).setText(prices[position]);
        return v;
    }
}
