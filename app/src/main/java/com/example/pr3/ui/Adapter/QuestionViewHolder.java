package com.example.pr3.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pr3.R;

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    private final TextView commonPerfumeIdItemView;
    private final TextView commonPerfumeNameItemView;


    private QuestionViewHolder(View itemView) {
        super(itemView);
        commonPerfumeIdItemView = itemView.findViewById(R.id.store_item_id);
        commonPerfumeNameItemView = itemView.findViewById(R.id.store_item_name);
    }

    public void bind(String nameText, int id) {
        commonPerfumeNameItemView.setText(nameText);
        commonPerfumeIdItemView.setText(Integer.toString(id));
    }

    static QuestionViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_item, parent, false);
        return new QuestionViewHolder(view);
    }

}
