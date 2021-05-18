package com.example.askdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AppointmentActivity extends AppCompatActivity {

    String firstname,lastname,mail,phoneno,gender;
    EditText e5,e6,e7,e8;
    DatabaseReference myRef;
    FirebaseAuth fAuth;
    RadioButton radiogendermale,radiogenderfemale;
    Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        e5 = findViewById(R.id.firstname);
        e6 = findViewById(R.id.lastname);
        e7 = findViewById(R.id.email);
        e8 = findViewById(R.id.phoneno);
        radiogendermale=(RadioButton)findViewById(R.id.radioButton_male);
        radiogenderfemale=(RadioButton)findViewById(R.id.radioButton_female);

        myRef = FirebaseDatabase.getInstance().getReference("patient_details");

        btn_result = (Button) findViewById(R.id.button);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstname = e5.getText().toString();
                lastname = e6.getText().toString();
                mail = e7.getText().toString();
                phoneno = e8.getText().toString();
                gender="";


                if(radiogendermale.isChecked()) {
                    gender="Male";
                }
                if(radiogenderfemale.isChecked()) {
                    gender="Female";
                }
                if(TextUtils.isEmpty(firstname)) {
                    e5.setError("Firstname is Required");
                    return;
                }
                if (TextUtils.isEmpty(lastname)) {
                    e6.setError("Lastname is required");
                    return;
                }
                if (TextUtils.isEmpty(mail)) {
                    e7.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(phoneno)) {
                    e8.setError("Enter Phoneno");
                }
                if (phoneno.length() != 10) {
                    e8.setError("Enter a 10 digit valid phoneno");
                    return;
                }

                Detail1 temp = new Detail1(firstname,lastname,mail,phoneno,gender);

                FirebaseDatabase.getInstance().getReference("patient_details").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(temp).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(getApplicationContext(),
                                Appointment2Activity.class));
                    }
                });
            }
        });
    }
}
