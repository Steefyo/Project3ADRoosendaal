package com.example.onboarding.Model.Start;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String StudentId;
    private String voornaam;
    private String achternaam;
    private String opleiding;
    private String Email;
    private String Bday;
    private String Woonplaats;
    private String Postcode;

    public User(String StudentId, String voornaam, String achternaam, String opleiding,String email, String bday, String woonplaats,String postcode){
        this.StudentId = StudentId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.opleiding = opleiding;
        this.Email = email;
        this.Bday = bday;
        this.Woonplaats = woonplaats;
        this.Postcode = postcode;
    }

    public User(JSONObject json) throws JSONException {
        this.StudentId = json.getString("studentId");
        this.voornaam = json.getString("voornaam");
        this.achternaam = json.getString("achternaam");
        this.opleiding = json.getString("opleiding");
        this.Email = json.getString("Email");
        this.Bday = json.getString("D.O.B");
        this.Woonplaats = json.getString("Woonplaats");
        this.Postcode = json.getString("Postcode");
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
    public String getEmail() { return Email; }
    public String getBday() { return Bday; }
    public String getWoonplaats() {return Woonplaats;}
    public String getPostcode() { return Postcode; }

    //Setters
    public void setStudentId(String studentId) {
        StudentId = studentId;
    }
    public void setvoornaam(String voornaam) { this.voornaam = voornaam; }
    public void setachternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    public void setopleiding(String opleiding) { this.opleiding = opleiding; }
    public void setEmail(String email) { this.Email = email; }
    public void setBday(String bday) { this.Bday = bday; }
    public void setWoonplaats(String woonplaats) {Woonplaats = woonplaats; }
    public void setPostcode(String postcode) { Postcode = postcode; }
}
