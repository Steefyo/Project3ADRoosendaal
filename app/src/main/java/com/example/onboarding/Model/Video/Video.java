package com.example.onboarding.Model.Video;

import org.json.JSONException;
import org.json.JSONObject;

public class Video {
    String Id, Titel;

    public String getId() {
        return Id;
    }

    public String getTitel() {
        return Titel;
    }

    public Video(String id, String titel) {
        Id = id;
        Titel = titel;
    }

    public Video(JSONObject json) throws JSONException {
        this.Id = json.getString("Id");
        this.Titel = json.getString("Titel");
    }

}
