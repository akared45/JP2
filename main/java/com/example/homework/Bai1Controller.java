package com.example.homework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Bai1Controller {
    @FXML
    private Label bai1;

    @FXML
    protected void handleButtonClick(){
        bai1.setText("Hello World");
    }
}
