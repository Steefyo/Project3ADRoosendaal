package com.example.onboarding.Controller.MenuPagina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Controller.FeedbackPagina.FeedbackActivity;
import com.example.onboarding.Controller.InfoPagina.InfoActivity;
import com.example.onboarding.Controller.PersonalPagina.PersonalActivity;
import com.example.onboarding.Controller.SocialPagina.SocialActivity;
import com.example.onboarding.Controller.VideoPagina.VideoPagina;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.Model.Menu.Status;
import com.example.onboarding.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private VolleyHelper helper;
    private Status status;
    ArrayList<MenuModel> menuItems = new ArrayList<>();
    ListView lv1 = null;

    String studentId;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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

        // Set default data
        status = new Status("demo", 0, 0, 0, 0, 0, 0);

        //------------------
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
        helper.get("Menu.php?studentId="+studentId, null, this, this);

        // Get All data from getListData();
        menuItems = getListData(status);

        // Get item from page.
        lv1 = findViewById(R.id.listview);

        // Create adapter and onclick
        lv1.setAdapter(new MenuAdapter(this, menuItems));

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

    private ArrayList<MenuModel> getListData(Status status) {
        // Make an empty list
        ArrayList<MenuModel> results = new ArrayList<>();

        // Fill the model, Add to the array
        results.add(new MenuModel(R.drawable.ic_launcher_foreground, "Video's", new Intent(this, VideoPagina.class).putExtra("StudentId", studentId), status.getFaseVideo()));
        results.add(new MenuModel(R.drawable.ic_launcher_background, "Social media", new Intent(this, SocialActivity.class).putExtra("StudentId", studentId), status.getFaseSocial()));
        results.add(new MenuModel(R.drawable.ic_launcher_foreground, "Personal info", new Intent(this, PersonalActivity.class).putExtra("StudentId", studentId), status.getFasePraktisch()));
        results.add(new MenuModel(R.drawable.ic_launcher_background, "Info", new Intent(this, InfoActivity.class).putExtra("StudentId", studentId), status.getFaseAboutR()));
        //results.add(new MenuModel(R.drawable.ic_launcher_foreground, "Feedback", new Intent(this, FeedbackActivity.class).putExtra("StudentId", studentId),0));

        // Return the array
        return results;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        // Execute JSON request
        try {
            // Fetch the row (student)
            JSONArray array = response.getJSONArray("student");

            // Get every student model
            for (int i = 0; i < array.length(); i++) {
                // Change the status based on the JSON data
                status = new Status(array.getJSONObject(i));

                // Update menu
                menuItems = getListData(status);

                System.out.println(menuItems);

                if(menuItems.get(0).getStatus() == 1 && menuItems.get(1).getStatus() == 1 && menuItems.get(2).getStatus() == 1 && menuItems.get(3).getStatus() == 1) {
                    Intent intent = new Intent(this, FeedbackActivity.class);
                    intent.putExtra("StudentId", studentId);
                    startActivity(intent);
                }

                // Refresh the view
                lv1.setAdapter(new MenuAdapter(this, menuItems));
            }
        }catch (JSONException e){
            System.out.println(e);
        }
    }
}