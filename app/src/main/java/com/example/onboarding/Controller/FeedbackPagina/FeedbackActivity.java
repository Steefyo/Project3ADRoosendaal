package com.example.onboarding.Controller.FeedbackPagina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.Controller.WelcomePagina.WelcomeActivity;
import com.example.onboarding.R;

public class FeedbackActivity extends AppCompatActivity {

    private Button buttonTerug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        buttonTerug = (Button) findViewById(R.id.buttonTerug);
        buttonTerug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sluitFeedbackActivity();
            }
        });
    }

    public void sluitFeedbackActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
