package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NextPage();
    }

    public void NextPage() {
        Intent intent =  new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
