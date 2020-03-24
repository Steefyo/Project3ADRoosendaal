package com.example.onboarding.Controller.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.*;
import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.Model.Start.User;
import com.example.onboarding.R;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private VolleyHelper helper;
    private User Student;
    ArrayList<MainModel> Students = new ArrayList<>();
    String studentId = "lvhulzen";
    TextView tvWelkom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Default Data
        Student = new User("Demo", "Test", "Test", "ICT");

        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        helper.get("Welkom.php?studentId=" + studentId, null, this, this);

        Students = getListData(Student);

        // Get item from page.
        tvWelkom = findViewById(R.id.tvWelcome);

        // Set Welcome
        if(Students.isEmpty() || Students == null) {
            tvWelkom.setText("Welkom");
        } else {
            tvWelkom.setText("Welkom " + Students.get(1).getWelkom() + "!");
        }
    }

    private ArrayList<MainModel> getListData(User student) {
        ArrayList<MainModel> results = new ArrayList<>();
        results.add(new MainModel("Stefan", "sgoever"));
        results.add(new MainModel("Lars", "lvhulzen"));

        return results;
    }

    public void toMenuPage(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("StudentId", studentId);
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error);
    }

    @Override
    public void onResponse(JSONObject response) {
    }
}