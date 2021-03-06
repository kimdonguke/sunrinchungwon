package com.example.sunrinchungwon.items;

import com.google.firebase.Timestamp;

import java.sql.Time;

public class recycler_item {
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_DATE = "date";
    public static final String FIELD_ISRESPONED = "isResponed";
    public static final String FIELD_TAG = "tag";
    public static final String FIELD_INTRODUCTION = "introduction";
    public static final String FIELD_MAINSUBJECT = "mainSubject";
    public static final String FIELD_CONCLUSION = "conclusion";
    String title;
    String isResponed;
    String introduction;//서론
    String mainSubject;//본론
    String conclusion;//결론
    String tag;
    Timestamp date;

    public recycler_item(String title, Timestamp timestamp , String isResponed, String introduction, String mainSubject, String conclusion, String tag) {
        this.title = title;
        this.isResponed = isResponed;
        this.introduction = introduction;
        this.mainSubject = mainSubject;
        this.conclusion = conclusion;
        this.tag = tag;
        this.date = timestamp;
    }

    public recycler_item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {

        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getIsResponed() {
        return isResponed;
    }

    public void setIsResponed(String isResponed) {
        this.isResponed = isResponed;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
