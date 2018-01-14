package com.example.stockmanagement.models;

import com.example.stockmanagement.utils.AppConfig;

import java.util.Date;

public class Product {
    int id;
    String title;
    String description;
    int quantity;
    String rate;
    String created_at;
    String updated_at;

    public Product() {
        this.id = 0;
        this.title = "";
        this.description = "";
        this.quantity = 0;
        this.rate = "";
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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
}
