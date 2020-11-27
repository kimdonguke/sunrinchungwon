package com.example.sunrinchungwon.items;

import java.util.Date;

public class seepost_item {
    String title,content,alpha_contents,userId,date;
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

    public String getAlpha_contents() {
        return alpha_contents;
    }

    public seepost_item(String title, String content, int viewType) {
        if(viewType==Code.ViewType.AGREE_CONTENT){
            userId=title;
            date=content;
        }
        else{
            this.title=title;
            if(content.length()>10){
                this.content=content.substring(0,9)+"....";
            }
            else{
                this.content=content;
                alpha_contents=content;
            }
        }
        this.viewType = viewType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
