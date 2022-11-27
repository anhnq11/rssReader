package com.example.rssload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private ArrayList<Model> list;
    private MyAdapter adapter;
    private ArrayList<Integer> listImg = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        list = new ArrayList<>();

        Intent intent = getIntent();
        String url = intent.getStringExtra("listLink");

        new ReadRSS().execute(url);
        adapter = new MyAdapter(this, list, listImg);
        listView.setAdapter(adapter);

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
    }

    private class ReadRSS extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeList1 = document.getElementsByTagName("description");
            String title = "";
            String link = "";
            String img = "";
            String des = "";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                des = nodeList1.item(i+1).getTextContent();
                list.add(new Model(title, link, img, des));
            }
            adapter.notifyDataSetChanged();
        }
    }
}