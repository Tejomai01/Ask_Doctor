package com.example.askdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class specialization4 extends AppCompatActivity {
    Button b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization4);
        b3=findViewById(R.id.dr7);
        b4=findViewById(R.id.dr8);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr7:
                        startActivity(new Intent(getApplicationContext(),
                                dermatologist1.class));
                        break;
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr8:
                        startActivity(new Intent(getApplicationContext(),
                                dermatologist2.class));
                        break;
                }

            }
        });

    }
}