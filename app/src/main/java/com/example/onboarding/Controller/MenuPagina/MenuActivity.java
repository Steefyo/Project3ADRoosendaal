package com.example.onboarding.Controller.MenuPagina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onboarding.Controller.FeedbackPagina.FeedbackActivity;
import com.example.onboarding.Controller.InfoPagina.InfoActivity;
import com.example.onboarding.Controller.PersonalPagina.PersonalActivity;
import com.example.onboarding.Controller.SocialPagina.SocialActivity;
import com.example.onboarding.Controller.VideoPagina.VideoPagina;
import com.example.onboarding.R;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

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
        // status is going to connect to the database

        //TODO: Database connection for the status of each menu item
        MenuStatusModel dbclass = new MenuStatusModel("sgoever", 1, 0, 0, 0, 0, 0);

        // Fill the model
        // Add to the array
        results.add(new MenuModel(R.drawable.ic_launcher_foreground, "Video's", new Intent(this, VideoPagina.class), dbclass.getFaseVideo()));
        results.add(new MenuModel(R.drawable.ic_launcher_background, "Social media", new Intent(this, SocialActivity.class), dbclass.getFaseSocial()));
        results.add(new MenuModel(R.drawable.ic_launcher_foreground, "Personal info", new Intent(this, PersonalActivity.class), dbclass.getFasePraktisch()));
        results.add(new MenuModel(R.drawable.ic_launcher_background, "Info", new Intent(this, InfoActivity.class), dbclass.getFaseAboutR()));
        results.add(new MenuModel(R.drawable.ic_launcher_foreground, "Feedback", new Intent(this, FeedbackActivity.class), 0));

        // Return the array
        return results;
    }
}