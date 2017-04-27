package com.example.kimsoohyeong.week9;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KimSooHyeong on 2017. 4. 27..
 */

public class GridViewAdapter extends BaseAdapter {
    ArrayList<Fruit> fruit;
    Context context;
    TextView tv;
    boolean isVisible = false;

    public GridViewAdapter(ArrayList<Fruit> fruit, Context context) {
        this.fruit = fruit;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = new GridItem(context);

        ((GridItem)convertView).setData(fruit.get(position));
        tv = (TextView)convertView.findViewById(R.id.tvprice);
        tv.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);

        return convertView;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void addFruit(Fruit one) {
        fruit.add(one);
        refresh();
    }

    public void change(boolean flag) {
        isVisible = flag;
    }

    public void modifyFruit(String name, int imageno, int price, int position) {
        Fruit modify = fruit.get(position);
        modify.setName(name);
        modify.setImgno(imageno);
        modify.setPrice(price);
        refresh();
    }
}
