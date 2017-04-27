package com.example.kimsoohyeong.week9;

/**
 * Created by KimSooHyeong on 2017. 4. 27..
 */

public class Fruit {
    final static String fruitlist[] = {"아보카도", "바나나", "체리", "크랜베리",
            "포도", "키위", "오렌지", "수박"};
    final static int imglist[] = {R.drawable.abocado, R.drawable.banana,
            R.drawable.cherry, R.drawable.cranberry,
            R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};

    private String name;
    private int imgno;
    private int price;

    public Fruit(String name, int imgno, int price) {
        this.name = name;
        this.imgno = imgno;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgno() {
        return imgno;
    }

    public void setImgno(int imgno) {
        this.imgno = imgno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
