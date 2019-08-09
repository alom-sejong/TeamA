package com.alomateam.gainapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.alomateam.gainapp.Card.CardManagerActivity;
import com.alomateam.gainapp.ParsingTest.CardParsingActivity;
import com.alomateam.gainapp.Pay.CategoryActivity;
import com.alomateam.gainapp.Pay.PayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cardActivityBtn = (Button) findViewById(R.id.cardActivityBtn);
        Button payActivityBtn = (Button) findViewById(R.id.payActivityBtn);
        Button cardListParsing = (Button) findViewById(R.id.cardListParsing);

        cardActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardManagerActivity.class));
            }
        });
        payActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CategoryActivity.class));
            }
        });

        cardListParsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardParsingActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(MainActivity.this, SettingActivity.class));
        return true;
    }
}
