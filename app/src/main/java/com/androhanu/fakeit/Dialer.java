package com.androhanu.fakeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Dialer extends AppCompatActivity {
    ImageButton imageButton;
    Chronometer chronometer;
    String name,num;
    TextView tvName, tvNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        imageButton = findViewById(R.id.imageButton2);
        chronometer = findViewById(R.id.chronometer2);
        tvName = findViewById(R.id.nameView);
        tvNum = findViewById(R.id.numView);
        chronometer.start();
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        num = intent.getStringExtra("num");

        tvName.setText(name);
        tvNum.setText(num);




        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Dialer.this, "call ended", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Dialer.this, MainActivity.class);
                        startActivity(intent);
                        chronometer.stop();
                        finish();


                    }
                },1000);
//                Intent intent = new Intent(Dialer.this, MainActivity.class);
//                startActivity(intent);
//                chronometer.stop();
//                finish();


            }
        });
    }
}