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


    @Column(name = "client_name", nullable = false)
    private String clientName;

    /*public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }*/


    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private Amenities serviceType;

    public Amenities getServiceType() {
        return serviceType;
    }

    public void setServiceType(Amenities serviceType) {
        this.serviceType = serviceType;
    }

    public SecuredObjects() {
    }

    public SecuredObjects(Long id, String objectAddress, String clientName) {
        this.id = id;
        this.objectAddress = objectAddress;
        this.clientName = clientName;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


}