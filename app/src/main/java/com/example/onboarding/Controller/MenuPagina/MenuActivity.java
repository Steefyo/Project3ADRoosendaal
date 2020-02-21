package com.example.onboarding.Controller.MenuPagina;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.onboarding.Controller.PersonalPagina.PersonalActivity;
import com.example.onboarding.Controller.VideoPagina.VideoPagina;
import com.example.onboarding.R;
import com.example.onboarding.Controller.SocialPagina.SocialActivity;

public class MenuActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Get All data from getListData();
        ArrayList<MenuModel> image_details = getListData();

        // Get item from page.
        final ListView lv1 = findViewById(R.id.listview);

        // Create adapter and onclick
        lv1.setAdapter(new MenuAdapter(this, image_details));
        lv1.setOnItemClickListener(new OnItemClickListener() {

            // Calculate automatically which item is selected.
            // Redirect to the correct page using the intent from the corresponding model.

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // Get model from certain position
                Object o = lv1.getItemAtPosition(position);

                // Convert model
                MenuModel menuModel = (MenuModel) o;

                // Redirect using the intent
                startActivity(menuModel.getPage());
            }
        });
    }

    private ArrayList<MenuModel> getListData() {
        // Make an empty list
        ArrayList<MenuModel> results = new ArrayList<MenuModel>();

        // Insert an item
        // Create an intent (the page where the item is linked to)
        // Fill the model
        // Add to the array
        Intent intentVideo =  new Intent(this, VideoPagina.class);
        MenuModel modelVideo = new MenuModel(R.drawable.ic_launcher_foreground, "Video's", intentVideo);
        results.add(modelVideo);

        Intent intentSocial =  new Intent(this, SocialActivity.class);
        MenuModel modelSocial = new MenuModel(R.drawable.ic_launcher_background, "Social media", intentSocial);
        results.add(modelSocial);

        Intent intentPersonal =  new Intent(this, PersonalActivity.class);
        MenuModel modelPersonal = new MenuModel(R.drawable.ic_launcher_foreground, "Personal info", intentPersonal);
        results.add(modelPersonal);

        // Return the array
        return results;
    }
}