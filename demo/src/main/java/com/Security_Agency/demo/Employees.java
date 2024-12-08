package com.Security_Agency.demo;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

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

    public Employees(int id, String full_name, String position, Date hire_date, int salary, String education) {
        this.id = id;
        this.full_name = full_name;
        this.position = position;
        this.hire_date = hire_date;
        this.salary = salary;
        this.education = education;
    }

    public Employees() {
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hire_date;
    private int salary;

    private String education;

    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<SecuredObjects> securedObject;

    public List<SecuredObjects> getSecuredObject() {
        return securedObject;
    }

    public void setSecuredObject(List<SecuredObjects> securedObject) {
        this.securedObject = securedObject;
    }
}
