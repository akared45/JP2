package com.example.dsa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentFormController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField hometownField;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private TableColumn<Student, String> hometownColumn;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        hometownColumn.setCellValueFactory(new PropertyValueFactory<>("hometown"));
        studentTable.setItems(studentList);

        addButton.setOnAction(event -> addStudent());

        nameColumn.setGraphic(new Label("Tên"));
        nameColumn.getGraphic().setOnMouseClicked(event -> sortByName());

        ageColumn.setGraphic(new Label("Tuổi"));
        ageColumn.getGraphic().setOnMouseClicked(event -> sortByAge());

        hometownColumn.setGraphic(new Label("Quê quán"));
        hometownColumn.getGraphic().setOnMouseClicked(event -> sortByHometown());

    }

    private void addStudent() {
        String name = nameField.getText();
        String age = ageField.getText();
        String hometown = hometownField.getText();

        if (name.isEmpty() || age.isEmpty() || hometown.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng điền đầy đủ thông tin!");
            alert.showAndWait();
            return;
        }

        try {
            int parsedAge = Integer.parseInt(age);
            studentList.add(new Student(name, parsedAge, hometown));
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Tuổi phải là số!");
            alert.showAndWait();
            return;
        }
        nameField.clear();
        ageField.clear();
        hometownField.clear();
    }

    private void sortByName() {
        ObservableList<Student> sortedList = FXCollections.observableArrayList(studentList);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j).getName().compareTo(sortedList.get(j + 1).getName()) > 0) {
                    Student temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        studentList.setAll(sortedList);
    }

    private void sortByAge() {
        ObservableList<Student> sortedList = FXCollections.observableArrayList(studentList);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j).getAge() > sortedList.get(j + 1).getAge()) {
                    // Hoán đổi vị trí
                    Student temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        studentList.setAll(sortedList);
    }

    private void sortByHometown() {
        ObservableList<Student> sortedList = FXCollections.observableArrayList(studentList);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j).getHometown().compareTo(sortedList.get(j + 1).getHometown()) > 0) {
                    Student temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        studentList.setAll(sortedList); 
    }
}
