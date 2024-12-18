package com.example.dsa;

public class Student {
    private final String name;
    private final int age;
    private final String hometown;

    public Student(String name, int age, String hometown) {
        this.name = name;
        this.age = age;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }
}
