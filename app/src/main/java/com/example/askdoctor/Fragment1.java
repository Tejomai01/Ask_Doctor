package com.example.askdoctor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private CardView physician, pediatrician, cardilogist, dermatologist, orthopedics;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment1_layout, container, false);
        physician = (CardView) rootview.findViewById(R.id.physician);
        pediatrician = (CardView) rootview.findViewById(R.id.paediatrics);
        cardilogist = (CardView) rootview.findViewById(R.id.cardiology);
        dermatologist = (CardView) rootview.findViewById(R.id.derma);
        orthopedics = (CardView) rootview.findViewById(R.id.ortho);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.physician:
                        startActivity(new Intent(getContext(), specialization.class));
                        break;
                }

            }
        });

        cardilogist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.cardiology:
                        startActivity(new Intent(getContext(), specialization3.class));
                        break;
                }
            }
        });

        dermatologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.derma:
                        startActivity(new Intent(getContext(), specialization4.class));
                        break;
                }
            }
        });

        orthopedics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ortho:
                        startActivity(new Intent(getContext(), specialization5.class));
                        break;
                }
            }
        });

        pediatrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.paediatrics:
                        startActivity(new Intent(getContext(), specialization2.class));
                        break;
                }
            }
        });
        return rootview;

    }
}





