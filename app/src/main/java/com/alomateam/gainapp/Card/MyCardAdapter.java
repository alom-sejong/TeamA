package com.alomateam.gainapp.Card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.alomateam.gainapp.R;

import java.util.ArrayList;

public class MyCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView tvName;

        MyViewHolder(View view){
            super(view);
            ivPicture = view.findViewById(R.id.iv_picture);
            tvName = view.findViewById(R.id.tv_name);
        }
    }
    private ArrayList<CardInfo> cardInfoArrayList;
    MyCardAdapter(ArrayList<CardInfo> cardInfoArrayList){
        this.cardInfoArrayList = cardInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);

        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.ivPicture.setImageResource(cardInfoArrayList.get(position).drawableId);
        myViewHolder.tvName.setText(cardInfoArrayList.get(position).name);
    }
    @Override
    public int getItemCount() {
        return cardInfoArrayList.size();
    }
}
