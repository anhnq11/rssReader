package com.example.rssload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    private ArrayList<String> listTitle = new ArrayList<>();
    private ArrayList<String> listLink = new ArrayList<>();
    private ArrayList<Integer> listImg = new ArrayList<>();
    private ArrayList<Model2> list2 = new ArrayList<>();
    ListView listMainMenu;
    private MyAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        listMainMenu = findViewById(R.id.listMainMenu);

        listTitle.add("BBQs");
        listTitle.add("Beer");
        listTitle.add("Drinks");
        listTitle.add("Grocery");
        listTitle.add("Meat");
        listTitle.add("Organic");
        listTitle.add("Pubs");
        listTitle.add("Restaurant");
        listTitle.add("Vegetables");
        listTitle.add("Wine");

        listLink.add("https://www.realwire.com/rss/?id=502");
        listLink.add("https://www.realwire.com/rss/?id=503");
        listLink.add("https://www.realwire.com/rss/?id=504");
        listLink.add("https://www.realwire.com/rss/?id=776");
        listLink.add("https://www.realwire.com/rss/?id=768");
        listLink.add("https://www.realwire.com/rss/?id=682");
        listLink.add("https://www.realwire.com/rss/?id=642");
        listLink.add("https://www.realwire.com/rss/?id=646");
        listLink.add("https://www.realwire.com/rss/?id=769");
        listLink.add("https://www.realwire.com/rss/?id=505");

        listImg.add(R.drawable.img1);
        listImg.add(R.drawable.img2);
        listImg.add(R.drawable.img3);
        listImg.add(R.drawable.img4);
        listImg.add(R.drawable.img5);
        listImg.add(R.drawable.img6);
        listImg.add(R.drawable.img7);
        listImg.add(R.drawable.img8);
        listImg.add(R.drawable.img9);
        listImg.add(R.drawable.img10);

        for (int i = 0; i < 10; i++) {
            list2.add(new Model2(listTitle.get(i), listLink.get(i), listImg.get(i)));
        }

        adapter = new MyAdapter2(this, list2);
        listMainMenu.setAdapter(adapter);
    }
}