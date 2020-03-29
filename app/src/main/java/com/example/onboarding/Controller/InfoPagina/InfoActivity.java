package com.example.onboarding.Controller.InfoPagina;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.R;

import org.json.JSONObject;

public class InfoActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    private VolleyHelper helper;
    private Button buttonTerug;

    String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //StudentId overnemen
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

        buttonTerug = findViewById(R.id.buttonTerug);
        buttonTerug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sluitInfoActivity();
            }
        });
    }

    //Functie om info weer af te sluiten en terug naar het menu te gaan.
    public void sluitInfoActivity() {
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        helper.get("InsertFase.php?FaseNaam=faseAboutR&StudentId="+studentId, null, this, this);
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("StudentId", studentId);
        startActivity(intent);

    }
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {

    }

}
