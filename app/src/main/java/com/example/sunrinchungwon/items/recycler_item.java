package com.example.sunrinchungwon.items;

public class recycler_item {
    String title;
    String date;
    String isResponed;

    public recycler_item(String title, String date, String isResponed) {
        this.title = title;
        this.date = date;
        this.isResponed = isResponed;
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

    public String getResponed() {
        return isResponed;
    }

    public void setResponed(String responed) {
        isResponed = responed;
    }
}
