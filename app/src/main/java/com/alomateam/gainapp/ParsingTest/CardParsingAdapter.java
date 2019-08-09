package com.alomateam.gainapp.ParsingTest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alomateam.gainapp.R;

import java.util.ArrayList;

public class CardParsingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static class CardParsingViewHolder extends RecyclerView.ViewHolder {
        ImageView cardParsingImage;
        TextView cardParsingName;

        CardParsingViewHolder(View view){
            super(view);
            cardParsingImage = view.findViewById(R.id.card_parsing_image);
            cardParsingName = view.findViewById(R.id.card_parsing_text);
        }
    }
    private ArrayList<CardParsingInfo> cardInfoArrayList;
    CardParsingAdapter(ArrayList<CardParsingInfo> cardInfoArrayList){
        this.cardInfoArrayList = cardInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_parsing_item, parent, false);

        return new CardParsingViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CardParsingViewHolder myViewHolder = (CardParsingViewHolder) holder;

        myViewHolder.cardParsingImage.setImageResource(cardInfoArrayList.get(position).drawableId);
        myViewHolder.cardParsingName.setText(cardInfoArrayList.get(position).name);
    }
    @Override
    public int getItemCount() {
        return cardInfoArrayList.size();
    }
}
