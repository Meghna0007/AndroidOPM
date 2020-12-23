package com.example.welcometoopm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Congo extends AppCompatActivity {
    ImageView MainActivity2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congo);
        MainActivity2 = findViewById(R.id.well);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 5 seconds
                Intent intent = new Intent(Congo.this,MainActivity2.class);
                startActivity(intent);
            }
        }, 3000);

    }
}