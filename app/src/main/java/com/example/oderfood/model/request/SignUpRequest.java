package com.example.oderfood.model.request;

import com.google.gson.annotations.SerializedName;

public class SignUpRequest {
    @SerializedName("fullname")
    private String fullName;

    @SerializedName("phone")
    private String phone;

    @SerializedName("password")
    private String password;

    public SignUpRequest(String fullName, String phone, String password) {
        this.fullName = fullName;
        this.phone = phone;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignInRequest{" +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
