package com.example.onboarding.Controller.MenuPagina;

import android.content.Intent;

public class MenuModel {

    private int image;
    private String title;
    private Intent page;    // Intent is the redirect to the other page

    MenuModel(int image, String title, Intent page) {   // All fields are required
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
    public Intent getPage() {
        return page;
    }
}
