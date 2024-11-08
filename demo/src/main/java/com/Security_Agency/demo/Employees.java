package com.Security_Agency.demo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String full_name;
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String edication) {
        this.education = edication;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Employees(int id, String full_name, String position, Date hire_date, int salary, String education, byte[] photo) {
        this.id = id;
        this.full_name = full_name;
        this.position = position;
        this.hire_date = hire_date;
        this.salary = salary;
        this.education = education;
        this.photo = photo;
    }

    // Default constructor
    public Employees() {
    }

    private Date hire_date;
    private int salary;

    private String education;

    private  byte[] photo;
}
