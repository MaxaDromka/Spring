package com.Security_Agency.demo;

import jakarta.persistence.*;


@Entity
@Table(name = "secured_objects")
public class SecuredObjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "object_address", nullable = false)
    private String objectAddress;

    @ManyToOne
    @JoinColumn(name = "client_name_id")
    private Client clientName;


    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private Amenities serviceType;

    @ManyToOne
    @JoinColumn(name = "emp_position_id")
    private Employees employees;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Amenities getServiceType() {
        return serviceType;
    }

    public void setServiceType(Amenities serviceType) {
        this.serviceType = serviceType;
    }

    public SecuredObjects() {
    }

    public SecuredObjects(Long id, String objectAddress) {
        this.id = id;
        this.objectAddress = objectAddress;
        //this.clientName = clientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectAddress() {
        return objectAddress;
    }

    public void setObjectAddress(String objectAddress) {
        this.objectAddress = objectAddress;
    }


    public Client getClientName() {
        return clientName;
    }

    public void setClientName(Client clientName) {
        this.clientName = clientName;
    }
}