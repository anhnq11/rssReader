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
    ListView listMainMenu;

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

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTitle);
        listMainMenu.setAdapter(adapter);

        listMainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainMenu.this, MainActivity.class);
                intent.putExtra("listLink", listLink.get(i));
                startActivity(intent);
            }
        });
    }
}