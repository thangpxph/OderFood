package com.example.oderfood.model;

import com.google.gson.annotations.SerializedName;

public class Table {
    @SerializedName("nameTable")
    private String nameTable;

    @SerializedName("amount")
    private int amount;

    @SerializedName("information")
    private String information;

    @SerializedName("status")
    private int status;

    public Table(String nameTable, int amount, String information, int status) {
        this.nameTable = nameTable;
        this.amount = amount;
        this.information = information;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
