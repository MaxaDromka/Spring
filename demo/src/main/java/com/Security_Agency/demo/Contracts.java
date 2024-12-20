package com.Security_Agency.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "contract_start_date", nullable = false)
    private java.sql.Date contractStartDate;

    @Column(name = "contract_end_date", nullable = false)
    private java.sql.Date contractEndDate;

    @Column(name = "contract_serial_number", nullable = false, unique = true, length = 50)
    private String contractSerialNumber;


    @OneToMany(mappedBy = "contracts", cascade = CascadeType.ALL)
    private List<Client> clients;

   /* @OneToMany(mappedBy = "revenues", cascade = CascadeType.ALL)
    private List<Revenue> revenues;*/

    @OneToOne
    @JoinColumn(name = "service_type_id")
    private Amenities amenities;

    /*@Column(name = "service_price")
    private double servicePrice;*/

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Contracts() {
    }

    public Contracts(int id, double amount, java.sql.Date contractStartDate, java.sql.Date contractEndDate,
                     String contractSerialNumber) {
        this.id = id;
        this.amount = amount;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractSerialNumber = contractSerialNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public java.sql.Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(java.sql.Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public java.sql.Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(java.sql.Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractSerialNumber() {
        return contractSerialNumber;
    }

    public void setContractSerialNumber(String contractSerialNumber) {
        this.contractSerialNumber = contractSerialNumber;
    }

}