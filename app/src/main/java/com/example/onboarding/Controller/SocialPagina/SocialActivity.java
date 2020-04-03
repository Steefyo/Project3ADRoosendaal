package com.example.onboarding.Controller.SocialPagina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Controller.MenuPagina.MenuActivity;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.R;

import org.json.JSONObject;

import java.util.ArrayList;

public class SocialActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    String studentId;
    private VolleyHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

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
        // Get All data from getListData();
        ArrayList<SocialModel> image_details = getListData();

        // Get item from page.
        final ListView lv1 = findViewById(R.id.listview);

        // Create adapter and onclick
        lv1.setAdapter(new SocialAdapter(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // Calculate automatically which item is selected.
            // Redirect to the correct page using the intent from the corresponding model.

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // Get model from certain position
                Object o = lv1.getItemAtPosition(position);

                // Convert model
                SocialModel menuModel = (SocialModel) o;

                // Open a web page based on the page value in the model
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(menuModel.getPage()));
                startActivity(i);
            }
        });
    }

    private ArrayList<SocialModel> getListData() {
        // Make an empty list
        ArrayList<SocialModel> results = new ArrayList<SocialModel>();

        // Insert an item
        // Fill the model
        // Add to the array
        results.add(new SocialModel(R.drawable.ic_launcher_foreground, "LinkedIn", "https://www.linkedin.com/"));
        results.add(new SocialModel(R.drawable.ic_launcher_background, "Facebook", "https://www.facebook.com/"));
        results.add(new SocialModel(R.drawable.ic_launcher_foreground, "Instagram", "https://www.instagram.com/"));

        // Return the array
        return results;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
    //word niet gebruikt maar het moet erin vanwege de implement
    }

    //Functie om Social weer af te sluiten en terug naar het menu te gaan.
    public void SluitSociaal(View view) {
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        helper.get("InsertFase.php?FaseNaam=faseSocial&StudentId="+studentId, null, this, this);
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("StudentId", studentId);
        startActivity(intent);
    }
}
