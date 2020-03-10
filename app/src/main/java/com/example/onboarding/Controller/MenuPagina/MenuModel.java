package com.example.onboarding.Controller.MenuPagina;

import android.content.Intent;

public class MenuModel {

    private int image;
    private String title;
    private Intent page;    // Intent is the redirect to the other page
    private int status;

    MenuModel(int image, String title, Intent page, int status) {   // All fields are required
        this.image = image;
        this.title = title;
        this.page = page;
        this.status = status;
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
    public int getStatus() {
        return status;
    }
}
