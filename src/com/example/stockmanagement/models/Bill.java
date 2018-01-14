package com.example.stockmanagement.models;

import com.example.stockmanagement.utils.AppConfig;

import java.util.Date;
import java.util.List;

public class Bill {
    int id;
    String title;
    String description;
    String amount;
    String paid;
    String created_at;
    String updated_at;

    public Bill() {
        this.id = 0;
        this.title = "";
        this.description = "";
        this.amount = "";
        this.paid = "";
        this.created_at = AppConfig.dateToString(new Date());
        this.updated_at = AppConfig.dateToString(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public List<Invoice> getInvoices(){
        return null;
    }
}
