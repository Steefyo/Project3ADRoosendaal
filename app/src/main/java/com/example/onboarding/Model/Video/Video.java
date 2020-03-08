package com.example.onboarding.Model.Video;

import org.json.JSONException;
import org.json.JSONObject;

public class Video {
    String VideoId, VideoTitel;

    public String GetVideoId() {
        return VideoId;
    }

    public String GetVideoTitel() {
        return VideoTitel;
    }

    public Video(String videoId, String videoTitel) {
        VideoId = videoId;
        VideoTitel = videoTitel;
    }

    public Video(JSONObject json) throws JSONException {
        this.VideoId = json.getString("VideoId");
        this.VideoTitel = json.getString("VideoTitel");
    }
}
