package com.example.askdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class specialization extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialization);

        b1=findViewById(R.id.dr1);
        b2=findViewById(R.id.dr2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr1:
                        startActivity(new Intent(getApplicationContext(),
                            physician1.class));
                        break;
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.dr2:
                        startActivity(new Intent(getApplicationContext(),
                                physician2.class));
                        break;
                }

            }
        });
    }
}