package com.androhanu.fakeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button call;
    EditText name;
    EditText phone;
    RadioGroup radioGroup;
    RadioButton radio;
    RadioButton radio1;
    RadioButton radio2;
    String owner, contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        call = findViewById(R.id.call);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        radio = findViewById(R.id.radio);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radioGroup = findViewById(R.id.radioGrp);



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, CallerScreen.class);
                        owner = name.getText().toString();
                        contact = phone.getText().toString();
                        intent.putExtra("name", owner);
                        intent.putExtra("phone", contact);
                        startActivity(intent);
                        finish();

                    }
                },100);
            }
        });

    }

}