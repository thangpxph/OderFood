package com.example.oderfood.model.response;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {
    @SerializedName("msg")
    private String notificationString;

    public SignUpResponse() {
    }

    public SignUpResponse(String notificationString) {
        this.notificationString = notificationString;
    }

    public String getNotificationString() {
        return notificationString;
    }

    public void setNotificationString(String notificationString) {
        this.notificationString = notificationString;
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "notificationString='" + notificationString + '\'' +
                '}';
    }
}
