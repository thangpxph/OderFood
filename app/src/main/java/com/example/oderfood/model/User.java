package com.example.oderfood.model;

public class User {
    String id;
    String email;
    String password;
    String name;
    String phone;
    String solantoian;
    String danhgia;

    public User(String id, String email, String password, String name, String phone, String solantoian, String danhgia) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.solantoian = solantoian;
        this.danhgia = danhgia;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSolantoian() {
        return solantoian;
    }

    public void setSolantoian(String solantoian) {
        this.solantoian = solantoian;
    }

    public String getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(String danhgia) {
        this.danhgia = danhgia;
    }
}
