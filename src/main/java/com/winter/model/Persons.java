package com.winter.model;

public class Persons {
    private Integer id;
    private String student_number;
    private String name;
    private String college;
    private String phone;
    private String email;

    public Integer getId() {
        return id;
    }

    public String getStudent_number() {
        return student_number;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
