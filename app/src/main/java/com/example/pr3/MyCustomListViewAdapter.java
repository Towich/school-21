package com.example.pr3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MyCustomListViewAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;
    private int layout;
    private List<String> list_items;

    public MyCustomListViewAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        list_items = objects;
        layout = resource;
        inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = inflater.inflate(layout, parent, false);

        ImageView list_item_image = view.findViewById(R.id.list_item_image);
        list_item_image.setImageResource(R.drawable.baseline_contact_support_24);

        TextView list_item_text = view.findViewById(R.id.list_item_text);
        list_item_text.setText(list_items.get(position));

        return view;
    }
}
