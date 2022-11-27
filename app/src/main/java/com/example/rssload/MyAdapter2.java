package com.example.rssload;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter2 extends BaseAdapter {

    private Context context;
    private ArrayList<Model2> list;

    public MyAdapter2 (Context context, ArrayList<Model2> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        }
        Model2 model = list.get(position);
        ImageView itemImg = convertView.findViewById(R.id.itemImg);
        TextView itemTitle = convertView.findViewById(R.id.itemTitle);
        itemTitle.setText(model.getListTittle());
        itemImg.setImageResource(model.getListImg());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("listLink", model.getListLink());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
