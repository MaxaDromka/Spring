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

    public String getEdication() {
        return edication;
    }

    public void setEdication(String edication) {
        this.edication = edication;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Employees(int id, String full_name, String position, Date hire_date, int salary, String edication, byte[] photo) {
        this.id = id;
        this.full_name = full_name;
        this.position = position;
        this.hire_date = hire_date;
        this.salary = salary;
        this.edication = edication;
        this.photo = photo;
    }

    private Date hire_date;
    private int salary;

    private String edication;

    private  byte[] photo;
}
