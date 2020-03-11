package com.example.onboarding.Model.Menu;

import org.json.JSONException;
import org.json.JSONObject;

public class Status {

    private String StudentId;
    private int faseVideo;
    private int faseOpleiding;
    private int faseAboutR;
    private int fasePraktisch;
    private int faseQuiz;
    private int faseSocial;

    public Status(String studentId, int faseVideo, int faseOpleiding, int faseAboutR, int fasePraktisch, int faseQuiz, int faseSocial) {
        this.StudentId = studentId;
        this.faseVideo = faseVideo;
        this.faseOpleiding = faseOpleiding;
        this.faseAboutR = faseAboutR;
        this.fasePraktisch = fasePraktisch;
        this.faseQuiz = faseQuiz;
        this.faseSocial = faseSocial;
    }

    public Status(JSONObject json) throws JSONException {
        this.StudentId = json.getString("studentId");
        this.faseVideo = json.getInt("faseVideo");
        this.faseOpleiding = json.getInt("faseOpleiding");
        this.faseAboutR = json.getInt("faseAboutR");
        this.fasePraktisch = json.getInt("fasePraktisch");
        this.faseQuiz = json.getInt("faseQuiz");
        this.faseSocial = json.getInt("faseSocial");
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public void setFaseVideo(int faseVideo) {
        this.faseVideo = faseVideo;
    }

    public void setFaseOpleiding(int faseOpleiding) {
        this.faseOpleiding = faseOpleiding;
    }

    public void setFaseAboutR(int faseAboutR) {
        this.faseAboutR = faseAboutR;
    }

    public void setFasePraktisch(int fasePraktisch) {
        this.fasePraktisch = fasePraktisch;
    }

    public void setFaseQuiz(int faseQuiz) {
        this.faseQuiz = faseQuiz;
    }

    public void setFaseSocial(int faseSocial) {
        this.faseSocial = faseSocial;
    }

    public String getStudentId() {
        return StudentId;
    }

    public int getFaseVideo() {
        return faseVideo;
    }

    public int getFaseOpleiding() {
        return faseOpleiding;
    }

    public int getFaseAboutR() {
        return faseAboutR;
    }

    public int getFasePraktisch() {
        return fasePraktisch;
    }

    public int getFaseQuiz() {
        return faseQuiz;
    }

    public int getFaseSocial() {
        return faseSocial;
    }
}
