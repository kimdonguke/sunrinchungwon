package com.example.sunrinchungwon.items;

import android.widget.ImageButton;

public class notification_item {
    String notificationTitle;
    String notificationDate;

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }



    public notification_item(String notificationTitle, String notificationDate) {
        this.notificationTitle = notificationTitle;
        this.notificationDate = notificationDate;

    }
}
