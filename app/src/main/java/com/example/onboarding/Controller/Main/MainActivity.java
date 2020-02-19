package com.example.onboarding.Controller.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onboarding.Controller.VideoPagina.VideoPagina;
import com.example.onboarding.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Send(View view) {
        Intent intent = new Intent(this, VideoPagina.class);
        startActivity(intent);

    }

}
