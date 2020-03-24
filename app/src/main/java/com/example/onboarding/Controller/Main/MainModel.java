package com.example.onboarding.Controller.Main;

public class MainModel {
    private String Naam;
    private String ID;

    MainModel(String Naam, String ID){
        this.Naam = Naam;
        this.ID = ID;
    }

    public String getWelkom() {return Naam; }

    public String getID() {return ID; }
}
