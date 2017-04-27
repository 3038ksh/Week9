package com.example.kimsoohyeong.week9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    ArrayList<Fruit> data = new ArrayList<>();
    GridView gridView;
    GridViewAdapter adapter;
    AddFruit addFruit;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        init();
    }

    private void init() {
        gridView = (GridView)findViewById(R.id.grid);
        adapter = new GridViewAdapter(data, this);

        addFruit = (AddFruit)findViewById(R.id.add);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imageno, int price) {
                adapter.addFruit(new Fruit(name, imageno, price));
            }

            @Override
            public void onModify(String name, int imageno, int price, int position) {
                adapter.modifyFruit(name, imageno, price, position);
            }

            @Override
            public Fruit getData(int pos) {
                return (Fruit)adapter.getItem(pos);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addFruit.putPos(position);
                addFruit.changeButton("M", false);
            }
        });


        gridView.setAdapter(adapter);

        cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adapter.change(isChecked);
                adapter.refresh();
            }
        });
    }
}
