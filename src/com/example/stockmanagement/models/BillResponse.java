package com.example.stockmanagement.models;

public class BillResponse {
    boolean flag;
    Bill bill;

    public BillResponse(boolean flag, Bill bill) {
        this.flag = flag;
        this.bill = bill;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
