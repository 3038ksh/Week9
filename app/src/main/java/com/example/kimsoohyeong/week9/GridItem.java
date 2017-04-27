package com.example.kimsoohyeong.week9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KimSooHyeong on 2017. 4. 27..
 */

public class GridItem extends LinearLayout {
    TextView tv1, tv2;
    ImageView img;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.grid_view_item, this);

        tv1 = (TextView)findViewById(R.id.tvname);
        tv2 = (TextView)findViewById(R.id.tvprice);
        img = (ImageView)findViewById(R.id.img1);
    }

    public void setData(Fruit one) {
        tv1.setText(one.getName());
        tv2.setText(one.getPrice() + "원");
        img.setImageResource(Fruit.imglist[one.getImgno()]);
    }
}
