package com.example.oderfood.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("msg")
    private String message;

    @SerializedName("token")
    private String token;

    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public LoginResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
