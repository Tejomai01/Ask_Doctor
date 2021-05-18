package com.example.askdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class specialization2 extends AppCompatActivity {
    Button b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization2);
        b3=findViewById(R.id.dr3);
        b4=findViewById(R.id.dr4);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr3:
                        startActivity(new Intent(getApplicationContext(),
                                paediatrician1.class));
                        break;
                }

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr4:
                        startActivity(new Intent(getApplicationContext(),
                                paediatrician2.class));
                        break;
                }

            }
        });

    }
}