package com.example.stockmanagement;

import com.example.stockmanagement.apis.ApiDatabase;
import com.example.stockmanagement.applications.AppLogin;
import javafx.application.Application;

public abstract class Main extends Application{
    public static void main(String[] args) {
        ApiDatabase.Migrate();
        new AppLogin().startApp();
    }
}
