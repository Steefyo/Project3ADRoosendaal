package com.example.onboarding.Controller.VideoPagina;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.onboarding.Helpers.VolleyHelper;
import com.example.onboarding.Model.Video.Video;
import com.example.onboarding.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CardFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    private static final String ARG_COUNT = "param1";
    private Integer counter;



    private VolleyHelper helper;
    private ArrayList<Video> Videos;

    private ArrayList<String> ids;
    private ArrayList<String> Titel;

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
        Videos = new ArrayList<Video>();
        Titel = new ArrayList<String>();
        ids = new ArrayList<String>();

        helper = new VolleyHelper(getContext(), "http://192.168.1.2//Api"); //Vul hier je eigen ipv4 in
        helper.get("api.php", null, this, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_card, container, false);
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        try {
            JSONArray array = jsonObject.getJSONArray("item");
            for(int i = 0 ; i < array.length() ; i++) {
                Videos.add(new Video(array.getJSONObject(i)));
            }
            for(Video video : Videos) {
                ids.add(video.GetVideoId());
                Titel.add(video.GetVideoTitel());
            }
            TextView TvTitel = this.getView().findViewById(R.id.LabelTitel);
            TvTitel.setText(Titel.get(counter));
            WebView mWebView = this.getView().findViewById(R.id.mWebView);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("http://www.youtube.com/embed/" + ids.get(counter));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }
}