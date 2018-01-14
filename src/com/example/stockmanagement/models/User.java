package com.example.stockmanagement.models;

import com.example.stockmanagement.utils.AppConfig;

import java.util.Date;

public class User {
    int id;
    String name;
    String email;
    String password;
    String address;
    String created_at;
    String updated_at;

    public User() {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.password = "";
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

}
