package com.example.askdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class specialization3 extends AppCompatActivity {
    Button b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization3);
        b3=findViewById(R.id.dr5);
        b4=findViewById(R.id.dr6);


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr5:
                        startActivity(new Intent(getApplicationContext(),
                                cardiologist1.class));
                        break;
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr6:
                        startActivity(new Intent(getApplicationContext(),
                                cardiologist2.class));
                        break;
                }

            }
        });


    }
}