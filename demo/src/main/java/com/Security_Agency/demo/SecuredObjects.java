package com.Security_Agency.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "secured_objects")
public class SecuredObjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "object_address", nullable = false)
    private String objectAddress;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "service_type", nullable = false)
    private String serviceType;

    public SecuredObjects() {
    }

    public SecuredObjects(int id, String objectAddress, String clientName, String serviceType) {
        this.id = id;
        this.objectAddress = objectAddress;
        this.clientName = clientName;
        this.serviceType = serviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectAddress() {
        return objectAddress;
    }

    public void setObjectAddress(String objectAddress) {
        this.objectAddress = objectAddress;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}