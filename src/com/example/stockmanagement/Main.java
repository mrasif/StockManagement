package com.example.stockmanagement;

import com.example.stockmanagement.apis.ApiDatabase;

public class Main {
    public static void main(String[] args) {
        ApiDatabase.Migrate();
    }
}
