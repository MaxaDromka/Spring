package com.Security_Agency.demo;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;


    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;


    @Column(name = "object_address", nullable = false)
    private String objectAddress;

    @Column(name = "contract_serial_number")
    private String contractSerialNumber;


    public Client() {
    }


    public Client(Long id, String fullName, String phoneNumber, String objectAddress, String contractSerialNumber) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.objectAddress = objectAddress;
        this.contractSerialNumber = contractSerialNumber;
    }
}