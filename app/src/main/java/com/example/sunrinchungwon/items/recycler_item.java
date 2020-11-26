package com.example.sunrinchungwon.items;

public class recycler_item {
    String title;
    String date;
    String isResponed;
    String introduction;//서론
    String mainSubject;//본론
    String conclusion;//결론
    String tag;

    public recycler_item(String title, String date, String isResponed, String introduction, String mainSubject, String conclusion, String tag) {
        this.title = title;
        this.date = date+"   "+tag;
        this.isResponed = isResponed;
        this.introduction = introduction;
        this.mainSubject = mainSubject;
        this.conclusion = conclusion;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
