package com.example.onboarding.Model.Start;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String StudentId;
    private String voornaam;
    private String achternaam;
    private String opleiding;

    public User(String StudentId, String voornaam, String achternaam, String opleiding){
        this.StudentId = StudentId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.opleiding = opleiding;
    }

    public User(JSONObject json) throws JSONException {
        this.StudentId = json.getString("studentId");
        this.voornaam = json.getString("voornaam");
        this.achternaam = json.getString("achternaam");
        this.opleiding = json.getString("opleiding");
    }

    //Getters
    public String getStudentId() {
        return StudentId;
    }
    public String getvoornaam() {
        return voornaam;
    }
    public String getachternaam() {
        return achternaam;
    }
    public String getopleiding() { return opleiding; }

    //Setters
    public void setStudentId(String studentId) {
        StudentId = studentId;
    }
    public void setvoornaam(String voornaam) { this.voornaam = voornaam; }
    public void setachternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    public void setopleiding(String opleiding) { this.opleiding = opleiding; }
}
