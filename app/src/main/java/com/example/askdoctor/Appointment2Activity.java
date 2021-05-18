package com.example.askdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Appointment2Activity extends AppCompatActivity
 {
    EditText edit;
    String date, time;
    EditText reason_symptoms,patient_name,patient_age;
    Context mcontext = this;
    EditText dateformat;
    Spinner preferred_dr;
    Button book;
    DatabaseReference myRef;
    Detail2 temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment2);

        reason_symptoms = findViewById(R.id.reason);
        patient_name=findViewById(R.id.name);
        patient_age=findViewById(R.id.age);
        myRef = FirebaseDatabase.getInstance().getReference("appointment_details");
        edit = (EditText) findViewById(R.id.time_1);
        dateformat = findViewById(R.id.dateformatID);
        book = (Button) findViewById(R.id.book);
        preferred_dr = findViewById(R.id.spinner);

        temp=new Detail2();

        List<String> Doctors = new ArrayList<>();
        Doctors.add(0,"choose Doctor");
        Doctors.add("Dr P.Naina (Physician)");
        Doctors.add("Dr M.Rahul (Paediatrician)");
        Doctors.add("Dr T.Aman (Cardiologist)");
        Doctors.add("Dr A.Tina (Dermatologist)");
        Doctors.add("Dr Y.Aakash (Orthopedic Surgeon)");
        Doctors.add("Dr H.Umesh (Physician)");
        Doctors.add("Dr Rakesh (Paediatrician)");
        Doctors.add("Dr A.Sanjay(Cardiologist)");
        Doctors.add("Dr Ajay Singh(Dermatologist)");
        Doctors.add("Dr Muskan Jain(Orthopedic Surgeon");


        ArrayAdapter<String> adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item,Doctors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        preferred_dr.setAdapter(adapter);

        preferred_dr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Select preferred dr", Toast.LENGTH_SHORT).show();


            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                temp.setName(patient_name.getText().toString());
                temp.setAge(patient_age.getText().toString());
                temp.setTime(edit.getText().toString());
               temp.setDate(dateformat.getText().toString());
               temp.setPreferred_dr(preferred_dr.getSelectedItem().toString());
                temp.setReason(reason_symptoms.getText().toString());



                FirebaseDatabase.getInstance().getReference("appointment_details").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(temp).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(getApplicationContext(),
                                SummaryActivity.class));
                    }
                });

            }
        });



        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == dateformat) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);

                }

                DatePickerDialog datePickerDialog = new DatePickerDialog(Appointment2Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        date = day + "/" + month + "/" + year;
                        dateformat.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mcontext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        edit.setText(hourOfDay + ":" + minute);
                        time = hourOfDay + ":" + minute;
                        edit.setText(time);
                    }
                }, hour, minute, android.text.format.DateFormat.is24HourFormat(mcontext));
                timePickerDialog.show();


            }
        });
    }
}
