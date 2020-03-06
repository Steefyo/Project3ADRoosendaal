package com.example.onboarding.Controller.VideoPagina;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    private static final String ARG_COUNT = "param1";
    private Integer counter;

    private VolleyHelper helper;
    private ArrayList<String> Videos;

    private String[] Youtube = {"rSwPBNu2Li8", "ZjJUVsmjIj4", "so4FwjfQ7YI", "rSwPBNu2Li8"};
    private String[] Titels = {"Gekke Titel", "Gekke Titel2", "Gekke Titel3", "Gekke Titel4"};

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance(Integer counter) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }
        Videos = new ArrayList<String>();
        helper = new VolleyHelper(getContext(), "http://145.48.228.130/Api"); //Vul hier je eigen ipv4 in
        helper.get("api.php", null, this, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            TextView TvTitel = view.findViewById(R.id.LabelTitel);
            TvTitel.setText(Titels[counter]);

            WebView mWebView = view.findViewById(R.id.mWebView);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("http://www.youtube.com/embed/" + Youtube[counter]);

            if (counter == Youtube.length - 1) {
                Button btnExit = view.findViewById(R.id.ExitKnop);
                btnExit.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            //niks nog
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
//        try {
//
//            JSONArray array = jsonObject.getJSONArray("item");
//            for(int i = 0 ; i < array.length() ; i++){
//                Videos.add(array.getJSONObject(i).getString("VideoId"));
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        //TODO Make Api work lmao
    }
    }