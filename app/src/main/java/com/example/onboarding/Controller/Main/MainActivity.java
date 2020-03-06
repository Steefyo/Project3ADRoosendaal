package com.example.onboarding.Controller.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.R;

public class MainActivity extends AppCompatActivity {

    //TODO: Static class with an user in it to emulate a logged in user.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toMenuPage(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}