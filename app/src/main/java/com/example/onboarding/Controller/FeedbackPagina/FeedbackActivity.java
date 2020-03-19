package com.example.onboarding.Controller.FeedbackPagina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.R;

public class FeedbackActivity extends AppCompatActivity {

    private Button buttonTerug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        buttonTerug = findViewById(R.id.buttonTerug);
        buttonTerug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sluitFeedbackActivity();
            }
        });
    }

    public void sluitFeedbackActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
