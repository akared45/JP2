package com.example.dsa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentFormController {
    @FXML
    private TableColumn<Student, String> studentIdColumn, nameColumn, hometownColumn, emailColumn, phoneColumn, classColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;
    @FXML
    public Button addButton;
    @FXML
    private TextField studentIdField, nameField, ageField, hometownField, emailField, phoneField, classField;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private ComboBox<String> sortComboBox, fieldComboBox;

    private final ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        hometownColumn.setCellValueFactory(new PropertyValueFactory<>("hometown"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        classColumn.setCellValueFactory(new PropertyValueFactory<>("classField"));
        studentTable.setItems(studentList);
        studentList.add(new Student("S003", "David", 20, "Da Nang", "alice@email.com", "0123456789", "Class A"));
        studentList.add(new Student("S005", "Bob", 22, "Saigon", "bob@email.com", "0123456790", "Class B"));
        studentList.add(new Student("S001", "Charlie", 21, "Hanoi", "charlie@email.com", "0123456781", "Class A"));
        studentList.add(new Student("S004", "Alice", 23, "Hue", "david@email.com", "0123456782", "Class C"));
        studentList.add(new Student("S002", "Eva", 24, "Nha Trang", "eva@email.com", "0123456783", "Class B"));
    }


    @FXML
    public void addStudent() {
        String studentId = studentIdField.getText();
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String hometown = hometownField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String studentClass = classField.getText();
        if (!studentId.isEmpty() && !name.isEmpty() && age > 0 && !hometown.isEmpty() && !email.isEmpty()) {
            Student student = new Student(studentId, name, age, hometown, email, phone, studentClass);
            studentList.add(student);
            clearFields();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Invalid Data");
            alert.setContentText("Please fill all required fields correctly.");
            alert.showAndWait();
        }
    }

    private void clearFields() {
        studentIdField.clear();
        nameField.clear();
        ageField.clear();
        hometownField.clear();
        emailField.clear();
        phoneField.clear();
        classField.clear();
    }

    public void sortStudents() {
        String selectedSort = sortComboBox.getValue();
        String selectedField = fieldComboBox.getValue();
        if (selectedSort != null && selectedField != null) {
            switch (selectedSort) {
                case "Bubble Sort":
                    bubbleSort(selectedField);
                    break;
                case "Insertion Sort":
                    insertionSort(selectedField);
                    break;
                case "Selection Sort":
                    selectionSort(selectedField);
                    break;
            }
        }
    }

    private void bubbleSort(String field) {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - i - 1; j++) {
                if (compare(studentList.get(j), studentList.get(j + 1), field) > 0) {
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
    }

    private void insertionSort(String field) {
        for (int i = 1; i < studentList.size(); i++) {
            Student key = studentList.get(i);
            int j = i - 1;
            while (j >= 0 && compare(studentList.get(j), key, field) > 0) {
                studentList.set(j + 1, studentList.get(j));
                j--;
            }
            studentList.set(j + 1, key);
        }
    }

    private void selectionSort(String field) {
        for (int i = 0; i < studentList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (compare(studentList.get(j), studentList.get(minIndex), field) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = studentList.get(i);
                studentList.set(i, studentList.get(minIndex));
                studentList.set(minIndex, temp);
            }
        }
    }

    private int compare(Student s1, Student s2, String field) {
        switch (field) {
            case "Name":
                return s1.getName().compareTo(s2.getName());
            case "Age":
                return Integer.compare(s1.getAge(), s2.getAge());
            case "Hometown":
                return s1.getHometown().compareTo(s2.getHometown());
            case "Email":
                return s1.getEmail().compareTo(s2.getEmail());
            case "Class":
                return s1.getClassField().compareTo(s2.getClassField());
            default:
                return 0;
        }
    }
}
