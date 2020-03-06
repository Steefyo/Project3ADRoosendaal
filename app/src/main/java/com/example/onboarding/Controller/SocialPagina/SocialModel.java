package com.example.onboarding.Controller.SocialPagina;

import android.content.Intent;

public class SocialModel {

    private int image;
    private String title;
    private String page;    // Intent is the redirect to the other page

    SocialModel(int image, String title, String page) {   // All fields are required
        this.image = image;
        this.title = title;
        this.page = page;
    }

    public int getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }
    public String getPage() {
        return page;
    }
}
