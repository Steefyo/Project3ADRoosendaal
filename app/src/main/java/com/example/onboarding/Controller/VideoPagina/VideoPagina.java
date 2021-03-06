package com.example.onboarding.Controller.VideoPagina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.Model.Video.Aantal;
import com.example.onboarding.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class VideoPagina extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    ViewPagerAdapter adapter = new ViewPagerAdapter(this);
    ViewPager2 viewPager;

    String studentId;

    private VolleyHelper helper;
    private ArrayList<Aantal> Aantal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            //StudentId ophalen.
            if(extras == null) {
                studentId = null;
            } else {
                studentId = extras.getString("StudentId");
            }
        } else {
            studentId = (String) savedInstanceState.getSerializable("StudentId");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_pagina);
        Aantal = new ArrayList<Aantal>();
        //Haalt het aantal Videos in de database op
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        helper.get("VideoAantal.php", null, this, this);
    }

    private ViewPagerAdapter createCardAdapter() {
        return adapter;
    }


    public void TerugKnop(View view) {
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        //geeft de FaseNaam en het StudentId mee.
        helper.get("InsertFase.php?FaseNaam=faseVideo&StudentId="+studentId, null, this, this);
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

        try {
            JSONArray array = response.getJSONArray("item");
            for (int i = 0; i < array.length(); i++) {
                Aantal.add(new Aantal(array.getJSONObject(i)));
            }
            for (Aantal aantal : Aantal){
                //geeft het aantal door aan de adapter
               adapter.setN(aantal.getAantal());
            }

            viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(createCardAdapter());

        }catch (JSONException e){
            System.out.println(e);
        }
    }
}
