package com.example.onboarding.Controller.SocialPagina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.onboarding.R;

import java.util.ArrayList;

public class SocialActivity extends AppCompatActivity {

    String studentId;

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
}
