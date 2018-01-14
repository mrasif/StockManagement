package com.example.stockmanagement.models;

import com.example.stockmanagement.utils.AppConfig;

import java.util.Date;

public class Invoice {
    int id;
    int product_id;
    int bill_id;
    int quantity;
    String created_at;
    String updated_at;

    public Invoice() {
        this.id = 0;
        this.product_id = 0;
        this.bill_id = 0;
        this.quantity = 0;
        this.created_at = AppConfig.dateToString(new Date());
        this.updated_at = AppConfig.dateToString(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
