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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Model> list;
    private ArrayList<Integer> listImg = new ArrayList<>();

    public MyAdapter (Context context, ArrayList<Model> list, ArrayList<Integer> listImg){
        this.context = context;
        this.list = list;
        this.listImg = listImg;
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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        }
        int index = position;
        Model model = list.get(position);
        ImageView itemImg = convertView.findViewById(R.id.itemImg);
        TextView itemTitle = convertView.findViewById(R.id.itemTitle);
        itemTitle.setText(model.getTitle());
        if (position >= 10){
            index = position - 10;
        }
        itemImg.setImageResource(listImg.get(index));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                TextView dialogTittle = dialog.findViewById(R.id.dialogTittle);
                ImageView dialogImg = dialog.findViewById(R.id.dialogImg);
                TextView dialogDes = dialog.findViewById(R.id.dialogDes);
                Button btnMore = dialog.findViewById(R.id.btnMore);
                Button btnClose = dialog.findViewById(R.id.btnClose);

                int index = position;
                if (position >= 10){
                    index = position - 10;
                }

                dialogTittle.setText(model.getTitle());
                dialogDes.setText(model.getDes());
                dialogImg.setImageResource(listImg.get(index));

                btnMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, MainActivity2.class);
                        intent.putExtra("linkNews", model.getLink());
                        context.startActivity(intent);
                        dialog.dismiss();
                    }
                });
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        return convertView;
    }
}
