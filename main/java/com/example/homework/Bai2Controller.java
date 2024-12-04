package com.example.homework;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class Bai2Controller {

    @FXML
    private ListView<String> oopFeaturesList;

    @FXML
    private TextArea featureDetails;

    @FXML
    public void initialize() {
        // Thêm các đặc tính vào danh sách
        oopFeaturesList.getItems().addAll("Encapsulation", "Inheritance", "Polymorphism", "Abstraction");
    }

    @FXML
    private void showFeatureDetails() {
        String selectedFeature = oopFeaturesList.getSelectionModel().getSelectedItem();

        if (selectedFeature != null) {
            switch (selectedFeature) {
                case "Encapsulation":
                    featureDetails.setText("Encapsulation is the process of hiding data and only exposing necessary parts through methods.");
                    break;
                case "Inheritance":
                    featureDetails.setText("Inheritance allows one class to acquire properties and methods from another class.");
                    break;
                case "Polymorphism":
                    featureDetails.setText("Polymorphism allows objects to take many forms. It supports method overriding and overloading.");
                    break;
                case "Abstraction":
                    featureDetails.setText("Abstraction focuses on essential qualities while hiding implementation details.");
                    break;
            }
        }
    }
}
