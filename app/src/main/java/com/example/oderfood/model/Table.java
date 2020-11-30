package com.example.oderfood.model;

import com.google.gson.annotations.SerializedName;

public class Table {
    @SerializedName("_id")
    private String id;

    @SerializedName("nameTable")
    private String nameTable;

    @SerializedName("amount")
    private int amount;

    @SerializedName("status")
    private int status;

    public Table(String id, String nameTable, int amount, int status) {
        this.id = id;
        this.nameTable = nameTable;
        this.amount = amount;
        this.status = status;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
