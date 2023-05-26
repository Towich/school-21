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
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr3.R;
import com.example.pr3.data.databases.entity.QuestionEntity;
import com.example.pr3.data.resources.QuestionModel;

import java.util.List;

public class QuestionRecyclerViewAdapter extends ListAdapter<QuestionModel, QuestionViewHolder> {

    public QuestionRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<QuestionModel> diffCallback) {
        super(diffCallback);
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return QuestionViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        QuestionModel current = getItem(position);
        holder.bind(current.getQuestion(), current.getId());
    }
    public static class WordDiff extends DiffUtil.ItemCallback<QuestionModel> {

        @Override
        public boolean areItemsTheSame(@NonNull QuestionModel oldItem, @NonNull QuestionModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull QuestionModel oldItem, @NonNull QuestionModel newItem) {
            return oldItem.getQuestion().equals(newItem.getQuestion());
        }
    }
}