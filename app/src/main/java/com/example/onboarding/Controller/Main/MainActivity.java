package com.example.onboarding.Controller.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.onboarding.Controller.WelcomePagina.WelcomeActivity;
import com.example.onboarding.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Send();
    }

    public void Send() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
