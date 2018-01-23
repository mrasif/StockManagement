package com.example.stockmanagement.scenes;

import com.example.stockmanagement.applications.AppDashboard;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.stockmanagement.utils.AllKeys;
import com.example.stockmanagement.utils.SharedPreferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DashboardScene extends AppDashboard{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBuyProducts;

    @FXML
    private Button btnProductTypes;

    @FXML
    private Button btnSellProducts;

    @FXML
    private Button btnInvoices;

    @FXML
    private Button btnManageCustomers;

    @FXML
    private Button btnLogout;

    @FXML
    void btnBuyProducts_Click(ActionEvent event) {
        new BuyProductScene().startApp();
    }

    @FXML
    void btnInvoices_Click(ActionEvent event) {

    }

    @FXML
    void btnLogout_Click(ActionEvent event) {
        SharedPreferences.putBoolean(AllKeys.IS_LOGIN,false);
        SharedPreferences.remove(AllKeys.USER_EMAIL);
        close(event);
    }

    @FXML
    void btnManageCustomers_Click(ActionEvent event) {

    }

    @FXML
    void btnProductTypes_Click(ActionEvent event) {
        new ProductTypeScene().startApp();
    }

    @FXML
    void btnSellProducts_Click(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnBuyProducts != null : "fx:id=\"btnBuyProducts\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnProductTypes != null : "fx:id=\"btnProductTypes\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnSellProducts != null : "fx:id=\"btnSellProducts\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnInvoices != null : "fx:id=\"btnInvoices\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnManageCustomers != null : "fx:id=\"btnManageCustomers\" was not injected: check your FXML file 'DashboardScene.fxml'.";
        assert btnLogout != null : "fx:id=\"btnLogout\" was not injected: check your FXML file 'DashboardScene.fxml'.";

    }
}
