package com.example.onboarding.Controller.FeedbackPagina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Controller.Main.MainActivity;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.R;

import org.json.JSONObject;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class FeedbackActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    String studentId;
    String opmerking;
    String rating;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button buttonAfronden;
    private VolleyHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //studentId waarde overnemen
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

        //On click toepassen aan de button met de functie "sluitFeedbackActivity"
        buttonAfronden = findViewById(R.id.buttonAfronden);
        buttonAfronden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sluitFeedbackActivity();

            }
        });
    }

    //Functie om de data door te sturen naar de API en de pagina te sluiten
    public void sluitFeedbackActivity() {
        try {
        // Het ID van de geselecteerde radiobutton opvragen
        radioGroup = findViewById(R.id.radio);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        View rb = radioGroup.findViewById(selectedId);
        radioButton = (RadioButton) radioGroup.getChildAt(radioGroup.indexOfChild(rb));
        rating = radioButton.getText().toString();

        //De opmerking van de editText in de feedback pagina uitlezen
        EditText editText = (EditText) findViewById(R.id.editText2);
        opmerking = editText.getText().toString();

        //De query met gegevens naar de api sturen

            helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t2/");
            helper.get("InsertFeedback.php?studentId="+studentId+"&opmerking="+opmerking+"&rating="+rating, null, this, this);

            //Color.rgb(77, 77, 143),Color.rgb(175, 51, 96),Color.rgb(16, 85, 172),Color.rgb(16, 172, 132),Color.rgb(255, 149, 0),
            //                            Color.rgb(125, 172, 16)
            //Gooit confetti wanneer de onboarding klaar is
            KonfettiView konfettiView = findViewById(R.id.konfettiView);
            konfettiView.build()
                    .addColors(Color.rgb(77, 77, 143),Color.rgb(175, 51, 96),Color.rgb(16, 85, 172),Color.rgb(16, 172, 132),Color.rgb(255, 149, 0),
                            Color.rgb(125, 172, 16))
                    .setDirection(0.0, 359.0)
                    .setSpeed(1f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(4000L)
                    .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                    .addSizes(new Size(12, 16))
                    .setPosition(konfettiView.getX()+konfettiView.getWidth()/2,konfettiView.getY()+konfettiView.getHeight()/3)
                    .burst(500);
        }
        catch (Exception e){
            System.out.println(e);
            Toast.makeText(getApplicationContext(),"Vul wat feedback in!",Toast.LENGTH_SHORT).show();
        }

        //De feedback pagina afsluiten
       // Intent intent = new Intent(this, MainActivity.class);
       // startActivity(intent);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        System.out.println(error);

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
