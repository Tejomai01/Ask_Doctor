package com.example.askdoctor;

import android.widget.Spinner;


public class Detail2 {
    public String date, time, reason,name,age;
    public String preferred_dr;

    public Detail2() {

    }

    public Detail2(String name,String age,String time, String date, Spinner preferred_dr, String reason) {

    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age=age;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getPreferred_dr() {
        return preferred_dr;
    }

    public void setPreferred_dr(String preferred_dr) {
        this.preferred_dr = preferred_dr;
    }

}