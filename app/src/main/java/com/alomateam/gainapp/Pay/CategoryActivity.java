package com.alomateam.gainapp.Pay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alomateam.gainapp.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        ImageView category[] = new ImageView[8];
        for(int i = 0; i < 8; i++){
            category[i] = findViewById(R.id.ca_1 + i);
            final int k = i;
            category[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),  k+ " clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
