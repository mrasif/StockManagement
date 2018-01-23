package com.example.stockmanagement.scenes;

import com.example.stockmanagement.apis.ApiDatabase;
import com.example.stockmanagement.applications.AppProductType;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.stockmanagement.models.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class ProductTypeScene extends AppProductType {

    ObservableList<Product> products;
    Product product;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfQuantity;

    @FXML
    private TextField tfRate;

    @FXML
    private TextField tfCreatedAt;

    @FXML
    private TextField tfUpdatedAt;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<Product> tvProducts;

    @FXML
    private TableColumn<?, ?> tcId;

    @FXML
    private TableColumn<?, ?> tcTitle;

    @FXML
    private TableColumn<?, ?> tcDescription;

    @FXML
    private TableColumn<?, ?> tcQuantity;

    @FXML
    private TableColumn<?, ?> tcRate;

    @FXML
    private TableColumn<?, ?> tcCreatedAt;

    @FXML
    private TableColumn<?, ?> tcUpdatedAt;

    @FXML
    void initialize() {
        assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tfDescription != null : "fx:id=\"tfDescription\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tfQuantity != null : "fx:id=\"tfQuantity\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tfRate != null : "fx:id=\"tfRate\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tfCreatedAt != null : "fx:id=\"tfCreatedAt\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tfUpdatedAt != null : "fx:id=\"tfUpdatedAt\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tvProducts != null : "fx:id=\"tvProducts\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcId != null : "fx:id=\"tcId\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcTitle != null : "fx:id=\"tcTitle\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcDescription != null : "fx:id=\"tcDescription\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcQuantity != null : "fx:id=\"tcQuantity\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcRate != null : "fx:id=\"tcRate\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcCreatedAt != null : "fx:id=\"tcCreatedAt\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        assert tcUpdatedAt != null : "fx:id=\"tcUpdatedAt\" was not injected: check your FXML file 'ProductTypeScene.fxml'.";
        setUI();

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                product=new Product();
                product.setTitle(tfTitle.getText());
                product.setDescription(tfDescription.getText());
                product.setRate(tfRate.getText());
                if(productValidate(tfTitle,tfDescription,tfRate)){
                    if(ApiDatabase.addProductType(product)){
                        products.clear();
                        products.addAll(ApiDatabase.getAllProducts());
                        displayTable(products);
                        JOptionPane.showMessageDialog(null,"Product Type saved.");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"It is not valid data.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"It is not valid data.");
                }
            }
        });

        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"It is not permitted.");
            }
        });

        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(productValidate(tfTitle,tfDescription,tfRate)){
                    product.setTitle(tfTitle.getText());
                    product.setDescription(tfDescription.getText());
                    product.setRate(tfRate.getText());
                    if(ApiDatabase.updateProductType(product)){
                        products.clear();
                        products.addAll(ApiDatabase.getAllProducts());
                        displayTable(products);
                        JOptionPane.showMessageDialog(null,"Product Type updated.");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"It is not valid data.");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"It is not valid data.");
                }
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tfId.setText("");
                tfTitle.setText("");
                tfDescription.setText("");
                tfQuantity.setText("0");
                tfRate.setText("0");
                tfCreatedAt.setText("");
                tfUpdatedAt.setText("");
                btnAdd.setDisable(false);
                btnUpdate.setDisable(true);
            }
        });

        tvProducts.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int index=tvProducts.getSelectionModel().getSelectedIndex();
                if(index>=0){
                    product=products.get(index);
                    tfId.setText(String.valueOf(product.getId()));
                    tfTitle.setText(product.getTitle());
                    tfDescription.setText(product.getDescription());
                    tfQuantity.setText(String.valueOf(product.getQuantity()));
                    tfRate.setText(product.getRate());
                    tfCreatedAt.setText(product.getCreated_at());
                    tfUpdatedAt.setText(product.getUpdated_at());
                }
            }
        });

    }

    private boolean productValidate(TextField tfTitle, TextField tfDescription, TextField tfRate) {
        if(null==tfTitle.getText() || tfTitle.getText().equals("")){
            tfTitle.requestFocus();
            return false;
        }
        if(null==tfDescription.getText() || tfDescription.getText().equals("")){
            tfDescription.requestFocus();
            return false;
        }
        if(null==tfRate.getText() || tfRate.getText().equals("")){
            tfRate.requestFocus();
            return false;
        }
        return true;
    }


    private void setUI() {
        tfId.setDisable(true);
        tfQuantity.setDisable(true);
        tfCreatedAt.setDisable(true);
        tfUpdatedAt.setDisable(true);
        btnRemove.setDisable(true);
        btnUpdate.setDisable(true);
        
        products= FXCollections.observableArrayList();
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tcQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tcRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        tcCreatedAt.setCellValueFactory(new PropertyValueFactory<>("created_at"));
        tcUpdatedAt.setCellValueFactory(new PropertyValueFactory<>("updated_at"));

        products.addAll(ApiDatabase.getAllProducts());
        displayTable(products);
    }

    private void displayTable(ObservableList<Product> products) {
        tvProducts.setItems(products);
    }

}
