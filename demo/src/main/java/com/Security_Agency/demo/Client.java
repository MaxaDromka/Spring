package com.Security_Agency.demo;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "contract_serial_number")
    private Contracts contracts;

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
    }

    public Client() {
    }

    public String getContractSerialNumber() {
        return contracts != null ? contracts.getContractSerialNumber() : null;
    }


    public Client(Long id, String fullName, String phoneNumber, String objectAddress) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.objectAddress = objectAddress;
    }
}