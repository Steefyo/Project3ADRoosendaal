package com.example.onboarding.Controller.PersonalPagina;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.R;

public class PersonalActivity extends AppCompatActivity {

    String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                studentId = null;
            } else {
                studentId = extras.getString("StudentId");
            }
        } else {
            studentId = (String) savedInstanceState.getSerializable("StudentId");
        }
    }
}
