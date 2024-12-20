package com.Security_Agency.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "services")
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name", nullable = false, unique = true, length = 100)
    private String serviceName;

    @Column(name = "service_description", nullable = false)
    private String serviceDescription;

    @Column(name = "service_price", nullable = false)
    private double servicePrice;


    @OneToOne (mappedBy = "amenities")
    private Contracts contracts;
    /*@OneToMany(mappedBy = "contracts", cascade = CascadeType.ALL)
    private List<Contracts> contracts;*/

    /*@OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<SecuredObjects> securedObject;*/

    // Конструкторы
    public Amenities() {
    }

    public Amenities(Long id, String serviceName, String serviceDescription, double servicePrice) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.servicePrice = servicePrice;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    /*public List<SecuredObjects> getSecuredObject() {
        return securedObject;
    }

    public void setSecuredObject(List<SecuredObjects> securedObject) {
        this.securedObject = securedObject;
    }*/
}