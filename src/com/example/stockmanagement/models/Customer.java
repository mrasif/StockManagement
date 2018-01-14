package com.example.stockmanagement.models;

import com.example.stockmanagement.apis.ApiDatabase;
import com.example.stockmanagement.utils.AppConfig;

import java.util.Date;
import java.util.List;

public class Customer {
    int id;
    String name;
    String mobile;
    String address;
    String created_at;
    String updated_at;

    public Customer() {
        this.id = 0;
        this.name = "";
        this.mobile = "";
        this.address = "";
        this.created_at = AppConfig.dateToString(new Date());
        this.updated_at = AppConfig.dateToString(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Bill> getBills(){
        return ApiDatabase.getBills(this.id);
    }
}
