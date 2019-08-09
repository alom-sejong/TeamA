package com.alomateam.gainapp.Card;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.ImageView;

import com.alomateam.gainapp.R;

import java.util.ArrayList;

public class MyCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPicture;
        TextView tvName;

        MyViewHolder(View view) {
            super(view);
            ivPicture = view.findViewById(R.id.iv_picture);
            tvName = view.findViewById(R.id.tv_name);
        }
    }

    private ArrayList<CardInfo> cardInfoArrayList;
    private ArrayList<CardInfo> cardInfoArrayListFiltered;

    MyCardAdapter(ArrayList<CardInfo> cardInfoArrayList) {
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

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    cardInfoArrayListFiltered = cardInfoArrayList;
                } else {
                    ArrayList<CardInfo> filteredList = new ArrayList<>();
                    for (CardInfo row : cardInfoArrayList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getName().toLowerCase().contains(charString.toLowerCase()) || row.getName().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    cardInfoArrayListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = cardInfoArrayListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                cardInfoArrayListFiltered = (ArrayList<CardInfo>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }
}