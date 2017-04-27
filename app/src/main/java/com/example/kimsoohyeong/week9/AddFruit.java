package com.example.kimsoohyeong.week9;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by KimSooHyeong on 2017. 4. 27..
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    int imageno = 0;
    int pos = -1;
    Context context;
    AutoCompleteTextView at;
    ImageView img;
    Button b_next, b_add;
    EditText et;
    boolean isAdd = true;

    public AddFruit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fruit_add, this);
        at = (AutoCompleteTextView)findViewById(R.id.f_name);
        img = (ImageView)findViewById(R.id.image1);
        b_next = (Button)findViewById(R.id.b_next);
        b_add = (Button)findViewById(R.id.b_add);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == b_add) {
            View view = View.inflate(context, R.layout.dlg, null);
            et = (EditText) view.findViewById(R.id.price);

            AlertDialog.Builder dlg = new AlertDialog.Builder(context);
            dlg.setTitle("가격 설정");
            dlg.setNegativeButton("취소", null);
            dlg.setPositiveButton("확인",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int price = Integer.parseInt(et.getText().toString());
                            if (isAdd) {
                                onAddListener.onAdd(at.getText().toString(), imageno, price);
                                clear();
                            } else {
                                onAddListener.onModify(at.getText().toString(), imageno, price, pos);
                                changeButton("ADD", true);
                            }
                        }
                    });
            dlg.setView(view);
            dlg.show();
        } else {
            imageno = (imageno + 1) % Fruit.fruitlist.length;
            img.setImageResource(Fruit.imglist[imageno]);
        }
    }

    interface OnAddListener {
        void onAdd(String name, int imageno, int price);
        void onModify(String name, int imageno, int price, int position);
        Fruit getData(int pos);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener) {
        this.onAddListener = onAddListener;
    }

    public void putPos(int pos) {
        this.pos = pos;
    }

    public void changeButton(String msg, boolean flag) {
        b_add.setText(msg);
        isAdd = flag;
        if (isAdd) {
            clear();
        } else {
            Fruit setData = onAddListener.getData(pos);
            at.setText(setData.getName());
            img.setImageResource(Fruit.imglist[setData.getImgno()]);
        }
    }

    public void clear() {
        at.setText("");
        img.setImageResource(Fruit.imglist[imageno = 0]);
    }
}
