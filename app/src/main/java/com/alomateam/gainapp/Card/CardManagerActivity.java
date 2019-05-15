package com.alomateam.gainapp.Card;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.alomateam.gainapp.R;

import java.util.ArrayList;

public class CardManagerActivity extends AppCompatActivity {

    CardFragmentAdapter fragmentAdapter;
    CardAddFragment cardAddFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_manager);

      //  ArrayList<Integer> cardImageArray = new ArrayList<>();

        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentAdapter = new CardFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter); // ViewPager와  FragmentAdapter 연결

        viewPager.setClipToPadding(false); // ViewPager의 미리 보기를 적용해주는 코드
        int dpValue = 30;
        float d = getResources().getDisplayMetrics().density;
        int margin = (int) (dpValue * d);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        // SharedPreference를 이용하여 Fragment의 개수 값을 얻어오고
        // for 문 돌려서 add 해야할 듯
        for (int i = 0; i < 1; i++) {
            cardAddFragment = new CardAddFragment();
            fragmentAdapter.addItem(cardAddFragment);
        }
        fragmentAdapter.notifyDataSetChanged();
    }
}
