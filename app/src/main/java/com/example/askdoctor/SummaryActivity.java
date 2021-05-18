package com.example.askdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SummaryActivity extends AppCompatActivity {
    EditText a,b,c,d,e,f;
    Button but;
    DatabaseReference myRef;
    FirebaseUser user;
    String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        user=FirebaseAuth.getInstance().getCurrentUser();
        myRef=FirebaseDatabase.getInstance().getReference("appointment_details");
        uid=user.getUid();

        a=(EditText) findViewById(R.id.name);
        b=(EditText) findViewById(R.id.enter_date);
        c=(EditText) findViewById(R.id.enter_time);
        d=(EditText) findViewById(R.id.enter_dr);
        e=(EditText) findViewById(R.id.enter_reason);
        f=(EditText) findViewById(R.id.age);


        but=(Button) findViewById(R.id.analysis);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Detail2 temp = snapshot.getValue(Detail2.class);

                        if(temp != null) {
                            String name=temp.name;
                            String age=temp.age;
                            String date=temp.date;
                            String time=temp.time;
                            String spinner=temp.preferred_dr;
                            String reason=temp.reason;

                            a.setText(name);
                            f.setText(age);
                            b.setText(date);
                            c.setText(time);
                            d.setText(spinner);
                            e.setText(reason);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(SummaryActivity.this,"Something Wrong Happened!",Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
