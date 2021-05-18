package com.example.askdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class specialization5 extends AppCompatActivity {
    Button b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization5);
        b3=findViewById(R.id.dr9);
        b4=findViewById(R.id.dr10);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr9:
                        startActivity(new Intent(getApplicationContext(),
                                orthopedics1.class));
                        break;
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr10:
                        startActivity(new Intent(getApplicationContext(),
                                orthopedics2.class));
                        break;
                }

            }
        });


    }
}