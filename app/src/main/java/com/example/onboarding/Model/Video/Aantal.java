package com.example.onboarding.Model.Video;

import org.json.JSONException;
import org.json.JSONObject;

public class Aantal {
    int Aantal;

    public Aantal(int aantal) {
        Aantal = aantal;
    }

    public int getAantal() {
        return Aantal;
    }

    public void setAantal(int aantal) {
        Aantal = aantal;
    }

    public Aantal(JSONObject json) throws JSONException {
        this.Aantal = json.getInt("COUNT(VideoId)");
    }
}
