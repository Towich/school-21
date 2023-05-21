package com.example.pr3.ui.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr3.R;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter<MyCustomRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private int layout;
    private Context context;
    private List<String> list_items;

    public MyCustomRecyclerViewAdapter(@NonNull Context context, @NonNull List<String> items) {
        list_items = items;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list_items.size();
    }

    @NonNull
    @Override
    public MyCustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.store_item_text.setText(list_items.get(position));
        holder.store_item_image.setImageResource(R.drawable.baseline_content_paste_24);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, list_items.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Log.i("RecyclerView", list_items.get(holder.getAdapterPosition()));
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView store_item_text;
        ImageView store_item_image;

        public ViewHolder(View view){
            super(view);
            store_item_text = view.findViewById(R.id.list_item_text);
            store_item_image = view.findViewById(R.id.list_item_image);
        }
    }
}
