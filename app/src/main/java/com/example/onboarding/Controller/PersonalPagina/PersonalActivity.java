package com.example.onboarding.Controller.PersonalPagina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.Model.Start.User;
import com.example.onboarding.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersonalActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    String studentId;
    private VolleyHelper helper;
    private ArrayList<User> Users;

    TextView TvStudentId;
    TextView TvNaam;
    TextView TvOpleiding;
    TextView TvEmail;
    TextView TvBday;
    TextView TvWoonplaats;
    TextView TvPostcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Users = new ArrayList<User>();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                studentId = null;
            } else {
                studentId = extras.getString("StudentId");
            }
        } else {
            studentId = (String) savedInstanceState.getSerializable("StudentId");
        }
        //Haal alle gegevens van een student op
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        helper.get("User.php?studentId=" + studentId, null, this, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error);
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
    //Maak alle Tekst views aan.
        TvStudentId = findViewById(R.id.TxtId);
        TvNaam = findViewById(R.id.TxtNaam);
        TvOpleiding = findViewById(R.id.TxtOpleiding);
        TvEmail = findViewById(R.id.TxtEmail);
        TvBday = findViewById(R.id.TxtBday);
        TvWoonplaats = findViewById(R.id.TxtWoonPlaats);
        TvPostcode = findViewById(R.id.TxtPostCode);
        //Haal alle gegevens van student op.
        try {
            JSONArray array = jsonObject.getJSONArray("student");
            for (int i = 0; i < array.length(); i++) {
                Users.add(new User(array.getJSONObject(i)));
            }
            //Zet alle gegevens in zn Tekst view
            for (User user : Users) {
                TvStudentId.setText("StudentId : "+user.getStudentId());
                TvNaam.setText("Naam : "+user.getvoornaam()+" "+user.getachternaam());
                TvOpleiding.setText("Opleiding : "+user.getopleiding());
                TvEmail.setText("Email : "+user.getEmail());
                TvBday.setText("D.O.B : "+user.getBday());
                TvWoonplaats.setText("Woonplaats : "+user.getWoonplaats());
                TvPostcode.setText("Postcode : "+user.getPostcode());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Terug(View view){
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        //geeft de FaseNaam en het StudentId mee.
        helper.get("InsertFase.php?FaseNaam=fasePraktisch&StudentId="+studentId, null, this, this);
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("StudentId", studentId);
        startActivity(intent);
    }
}


