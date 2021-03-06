package com.example.stockmanagement.models;

import com.example.stockmanagement.apis.ApiDatabase;
import com.example.stockmanagement.utils.AppConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
    int id;
    String title;
    String description;
    String amount;
    String paid;
    int customer_id;
    String created_at;
    String updated_at;
    List<Invoice> invoices;

    public Bill() {
        this.id = 0;
        this.title = "";
        this.description = "";
        this.amount = "";
        this.paid = "";
        this.customer_id=0;
        this.created_at = AppConfig.dateToString(new Date());
        this.updated_at = AppConfig.dateToString(new Date());
        invoices=new ArrayList<>();
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices(){
        return ApiDatabase.getInvoices(this.id);
    }

    public Customer getCustomer(){
        return ApiDatabase.getCustomer(this.getCustomer_id());
    }
}
