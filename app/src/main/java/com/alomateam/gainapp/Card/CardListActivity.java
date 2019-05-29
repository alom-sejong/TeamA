package com.alomateam.gainapp.Card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alomateam.gainapp.R;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<CardInfo> cardInfoArrayList = new ArrayList<>();
        cardInfoArrayList.add(new CardInfo(R.drawable.a1,"AK_KB국민_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a2,"H_Point_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a3,"LG_U플러스_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a4,"Liiv_Mate_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a5,"ONE_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a6,"Young_Youth_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a7,"가온_올포인트_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a8,"가온_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a9,"골든라이프_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a10,"노리_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a11,"누리_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a12,"민_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a13,"비트윈_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a14,"스타_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a15,"스피드메이트_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a16,"아모레퍼시픽_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a17,"아시아나_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a18,"음_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a19,"정_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a20,"주니어라이프_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a21,"직장인보너스_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a22,"청춘대로_싱글_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a23,"카카오페이_KB국민_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a24,"티머니_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a25,"포인트리_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a26,"해피CU포인트_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a27,"해피포인트_KB국민_체크카드"));
        cardInfoArrayList.add(new CardInfo(R.drawable.a28,"훈_체크카드"));

        MyCardAdapter mycardadapter = new  MyCardAdapter(cardInfoArrayList);
        mRecyclerView.setAdapter(mycardadapter);

    }
}