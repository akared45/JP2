package com.example.homework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    protected void bai1show() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bai1.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Bai 1");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void bai2show() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bai2.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Bai 2");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void bai3show() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bai3.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Bai 3");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}