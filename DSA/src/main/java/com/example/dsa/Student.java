package com.example.dsa;

public class Student {

    private String studentId;
    private String name;
    private int age;
    private String hometown;
    private String email;
    private String phone;
    private String classField;

    public Student() {
    }

    public Student(String studentId, String name, int age, String hometown, String email, String phone, String classField) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.hometown = hometown;
        this.email = email;
        this.phone = phone;
        this.classField = classField;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassField() {
        return classField;
    }

    public void setClassField(String classField) {
        this.classField = classField;
    }
}
