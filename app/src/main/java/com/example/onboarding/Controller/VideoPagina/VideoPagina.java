package com.example.onboarding.Controller.VideoPagina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
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

    private VolleyHelper helper;
    private ArrayList<Aantal> Aantal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_pagina);
        Aantal = new ArrayList<Aantal>();
        helper = new VolleyHelper(getBaseContext(), "http://192.168.1.2//Api"); //Vul hier je eigen ipv4 in
        helper.get("api2.php", null, this, this);
    }

    private ViewPagerAdapter createCardAdapter() {
        return adapter;
    }


    public void TerugKnop(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

        try {
            JSONArray array = response.getJSONArray("item");
            for (int i = 0; i < array.length(); i++) {
                Aantal.add(new Aantal(array.getJSONObject(i)));
            }
            for (Aantal aantal : Aantal){
               adapter.setN(aantal.getAantal());
            }
            viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(createCardAdapter());

        }catch (JSONException e){
            System.out.println(e);
        }


    }
}
