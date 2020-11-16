package com.example.sunrinchungwon.items;

import java.util.Date;

public class seepost_item {
    String title,content,userId,date;
    private int viewType;

    public String getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getViewType() {
        return viewType;
    }

    public seepost_item(String title, String content, int viewType) {
        if(viewType==Code.ViewType.AGREE_CONTENT){
            userId=title;
            date=content;
        }
        else{
            this.title=title;
            this.content=content;
        }
        this.viewType = viewType;
    }
}
