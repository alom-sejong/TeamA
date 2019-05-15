package com.alomateam.gainapp.Card;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.alomateam.gainapp.R;

@SuppressLint("ValidFragment")
public class CardAddFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.card_add, container, false);

        final ImageView cardImage = (ImageView) rootView.findViewById(R.id.cardImage);

        final Button addCardFragment = (Button) rootView.findViewById(R.id.addCardBtn);
        addCardFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardImage.setVisibility(View.VISIBLE);
                addCardFragment.setVisibility(View.GONE);

                ((CardManagerActivity)getActivity()).cardAddFragment = new CardAddFragment();
                ((CardManagerActivity)getActivity()).fragmentAdapter.addItem(((CardManagerActivity)getActivity()).cardAddFragment);
                ((CardManagerActivity)getActivity()).fragmentAdapter.notifyDataSetChanged();
            }
        });
        return rootView;
    }
}
