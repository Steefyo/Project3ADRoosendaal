package com.example.onboarding.Controller.InfoPagina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.R;

public class InfoActivity extends AppCompatActivity {

    private Button buttonTerug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        buttonTerug = findViewById(R.id.buttonTerug);
        buttonTerug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sluitInfoActivity();
            }
        });
    }

    public void sluitInfoActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
