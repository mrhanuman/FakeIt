package com.androhanu.fakeit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CallerScreen extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton greenBt, redBt;
    TextView tvName, tvNum;
    String name, num,ownerName,ownernum;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller_screen);
        greenBt = findViewById(R.id.greenBt);
        redBt = findViewById(R.id.redBt);
        tvNum = findViewById(R.id.numView);
        tvName = findViewById(R.id.nameView);



        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        num = intent.getStringExtra("phone");

        tvName.setText(name);
        tvNum.setText(num);
        ownerName = tvName.getText().toString();
        ownernum = tvNum.getText().toString();



        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


        greenBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CallerScreen.this, Dialer.class);
                intent.putExtra("name",ownerName);
                intent.putExtra("num", ownernum);
                mediaPlayer.stop();
                startActivity(intent);
                finish();
            }
        });

        redBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CallerScreen.this, MainActivity.class);

                startActivity(intent);
                mediaPlayer.stop();
                finish();
            }
        });
    }
}