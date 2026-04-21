package com.example.myapplication.model;

public class Student {
    private int id;
    private String code;
    private String name;
    private String img;
    private int classID;
    private String className;

    public Student() {
    }

    public Student(int id, int classID, String img, String name, String code) {
        this.id = id;
        this.classID = classID;
        this.img = img;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
