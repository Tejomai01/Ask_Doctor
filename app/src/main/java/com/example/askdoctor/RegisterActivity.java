package com.example.askdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    String username,email,password,conformpassword;
    EditText e1,e2,e3,e4;
    Button b1;
    ProgressBar progressBar;
    DatabaseReference myRef;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.email);
        e3 = findViewById(R.id.password);
        e4 = findViewById(R.id.cpassword);

        b1=findViewById(R.id.btn_reg);

        myRef = FirebaseDatabase.getInstance().getReference("register_details");


        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progress_bar);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = e1.getText().toString().trim();
                email = e2.getText().toString().trim();
                password = e3.getText().toString().trim();
                conformpassword = e4.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                   e2.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(username)) {
                    e1.setError("Username is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    e3.setError("Password is required");
                    return;
                }

                if (TextUtils.isEmpty(conformpassword)) {
                    e4.setError("Re-enter the password");
                }

                if (password.length() < 6) {
                    e3.setError("Password must have atleast 6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Detail info = new Detail(username,email);
                            FirebaseDatabase.getInstance().getReference("register_details").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(RegisterActivity.this,"User created successfully!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),
                                            LoginActivity.class));
                                }
                            });

                        }else {
                            Toast.makeText(RegisterActivity.this, "Failed to register!Try again! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }


}