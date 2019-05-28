package com.alomateam.gainapp.Pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.alomateam.gainapp.R;
import java.util.ArrayList;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class CategoryActivity extends AppCompatActivity {

    AutoScrollViewPager autoViewPager;
    ImageView category[] = new ImageView[8];
    ArrayList<CharSequence[]> charSequences = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final ArrayList<String> data = new ArrayList<>();
        data.add("https://github.com/alom-sejong/TeamA/raw/master/app/src/main/res/drawable/slide_1.png");
        data.add("https://github.com/alom-sejong/TeamA/raw/master/app/src/main/res/drawable/slide_2.png");
        data.add("https://github.com/alom-sejong/TeamA/raw/master/app/src/main/res/drawable/slide_3.png");
        data.add("https://github.com/alom-sejong/TeamA/raw/master/app/src/main/res/drawable/slide_4.png");

        autoViewPager = (AutoScrollViewPager)findViewById(R.id.autoViewPager);
        AutoScrollAdapter scrollAdapter = new AutoScrollAdapter(this, data);
        autoViewPager.setAdapter(scrollAdapter);
        autoViewPager.setInterval(5000);
        autoViewPager.startAutoScroll();

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);
        charSequences.add(new CharSequence[] {"스타벅스", "커피빈", "그외"});
        charSequences.add(new CharSequence[] {"아웃백", "VIPS", "TGIF", "세븐스프링스", "그외"});
        charSequences.add(new CharSequence[]{"CGV", "롯데시네마", "메가박스"});
        charSequences.add(new CharSequence[]{"지하철/버스", "택시"});
        charSequences.add(new CharSequence[]{"이마트","롯데마트","홈플러스","그외"});
        charSequences.add(new CharSequence[]{"GS25", "CU", "세븐일레븐", "그외"});
        charSequences.add(new CharSequence[]{"롯데월드", "에버랜드", "서울랜드"});
        charSequences.add(new CharSequence[]{"쿠팡", "위메프", "티"});

        for(int i = 0; i < 8; i++){
            category[i] = findViewById(R.id.ca_1 + i);
            final int k = i;
            category[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.setTitle("사용처를 선택하세요").setItems(charSequences.get(k), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), charSequences.get(k)[i], Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(CategoryActivity.this, PayActivity.class);
                            intent.putExtra("value", charSequences.get(k)[i].toString());
                            startActivity(intent);
                        }
                    }).setCancelable(true).show();
                }
            });
        }
    }
}
