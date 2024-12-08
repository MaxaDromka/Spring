package com.Security_Agency.demo;

import jakarta.persistence.*;

import java.util.List;

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

    @Column(name = "service_type", nullable = false, length = 100)
    private String serviceType;

    @OneToMany(mappedBy = "contracts", cascade = CascadeType.ALL)
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Contracts() {
    }

    public Contracts(int id, double amount, java.sql.Date contractStartDate, java.sql.Date contractEndDate,
                     String contractSerialNumber, String serviceType) {
        this.id = id;
        this.amount = amount;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractSerialNumber = contractSerialNumber;
        this.serviceType = serviceType;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}